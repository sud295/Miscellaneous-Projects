'''
The purpose of this program is to search for all the prime numbers between 0 and 7
Implements Grover's algorithm to solve this in sqrt(N) time complexity as opposed to linear time for brute force.
'''

from qiskit import Aer, QuantumCircuit, execute, IBMQ
from qiskit.visualization import plot_histogram
from matplotlib import pyplot as pt

def oracle(n, name = "oracle"): # Defining the Oracle or the first "Black Box"
    qc = QuantumCircuit(n)
    qc.mct([0,1,2], (3))

    qc.barrier() 
    qc.x(1)
    qc.x(2)
    qc.mct([0,1,2], (3))
    qc.x(1)
    qc.x(2)

    qc.barrier()
    qc.x(0)
    qc.x(2)
    qc.mct([0,1,2], (3))
    qc.x(0)
    qc.x(2)

    qc.barrier()
    qc.x(2)
    qc.mct([0,1,2], (3))
    qc.x(2)

    qc.barrier()
    qc.x(1)
    qc.mct([0,1,2], (3))
    qc.x(1)

    return(qc)

def diffuser(n, name = "diffuser"): # Defining the diffuser which is a key component of the "pase kickback"/amplification process
    qc = QuantumCircuit(n)
    qc.h(range(n-1))
    qc.x(range(n-1))
    qc.mcx([0,1,2], 3)
    qc.x(range(n-1))
    qc.h(range(n-1))

    return(qc)

diffuser(4)

qc = QuantumCircuit(4, 3) #Defining circuit: 4 Quibits (including 1 Ancilla) and 3 output classical bits

qc.h(range(3)) # Creating an innitial superposition on all used qubits (except ancilla)

qc.x(3) # inverting phase of ancilla
qc.h(3)

oracle(4)
qc.append(diffuser(4), range(4))

qc.append(oracle(4), range(4))
qc.append(diffuser(4), range(4))

qc.append(oracle(4), range(4))
qc.append(diffuser(4), range(4))

qc.measure(range(3), range(3)) # measuring states

simulator = Aer.get_backend('qasm_simulator') # running on simulator
job = execute(qc, backend=simulator, shots=1000)
counts = job.result().get_counts()

plot_histogram(counts)
pt.show()
print(qc)
