from qiskit import QuantumCircuit, assemble, Aer, execute, transpile
from qiskit.visualization import plot_histogram
import numpy as np
from matplotlib import pyplot

query = input("What to search?: ")

def oracle(n): # A "Conditional Oracle" of sorts. Depending on the input of the user, the oracle is constructed differently
    qc = QuantumCircuit(n)
    if query == "1111":
        qc.mct([0,1,2,3], 4)
    elif query == "1110":
        qc.x(0)
        qc.mct([0,1,2,3], 4)
        qc.x(0)
    elif query == "1101":
        qc.x(1)
        qc.mct([0,1,2,3], 4)
        qc.x(1)
    elif query == "1011":
        qc.x(2)
        qc.mct([0,1,2,3], 4)
        qc.x(2)
    elif query == "0111":
        qc.x(3)
        qc.mct([0,1,2,3], 4)
        qc.x(3)
    elif query == "1100":
        qc.x(0)
        qc.x(1)
        qc.mct([0,1,2,3], 4)
        qc.x(0)
        qc.x(1)
    elif query == "1001":
        qc.x(2)
        qc.x(1)
        qc.mct([0,1,2,3], 4)
        qc.x(2)
        qc.x(1)
    elif query == "0110":
        qc.x(0)
        qc.x(3)
        qc.mct([0,1,2,3], 4)
        qc.x(0)
        qc.x(3)
    elif query == "0101":
        qc.x(1)
        qc.x(3)
        qc.mct([0,1,2,3], 4)
        qc.x(1)
        qc.x(3)
    elif query == "1010":
        qc.x(0)
        qc.x(2)
        qc.mct([0,1,2,3], 4)
        qc.x(0)
        qc.x(2)
    elif query == "0011":
        qc.x(2)
        qc.x(3)
        qc.mct([0,1,2,3], 4)
        qc.x(2)
        qc.x(3)
    elif query == "1000":
        qc.x(0)
        qc.x(1)
        qc.x(2)
        qc.mct([0,1,2,3], 4)
        qc.x(0)
        qc.x(1)
        qc.x(2)
    elif query == "0001":
        qc.x(1)
        qc.x(2)
        qc.x(3)
        qc.mct([0,1,2,3], 4)
        qc.x(1)
        qc.x(2)
        qc.x(3)
    elif query == "0100":
        qc.x(0)
        qc.x(1)
        qc.x(3)
        qc.mct([0,1,2,3], 4)
        qc.x(0)
        qc.x(1)
        qc.x(3)
    elif query == "0010":
        qc.x(0)
        qc.x(2)
        qc.x(3)
        qc.mct([0,1,2,3], 4)
        qc.x(0)
        qc.x(2)
        qc.x(3)
    elif query == "0000":
        qc.x(3)
        qc.x(2)
        qc.x(1)
        qc.x(0)
        qc.mct([0,1,2,3], 4)
        qc.x(3)
        qc.x(2)
        qc.x(1)
        qc.x(0)
    return(qc)


def diffuser(n): # defining the diffuser
    qc = QuantumCircuit(n)
    
    # Setting up 1st layer of hadamard gates 
    for i in range(n-1): 
        qc.h(i)

    for j in range(n-1):
        qc.x(j)

    qc.mct([0,1,2,3], 4) #Multi C-Not gate targetting qubit 4 

    for j in range(n-1):
        qc.x(j)

    # Setting up 2nd layer of hadamard gates

    for i in range(n-1):
        qc.h(i)
    return qc
    

n=5

circuit = QuantumCircuit(n, n-1)

numberOfSolutions = 1

r = int(np.floor(np.pi/4*np.sqrt(2**(n-1)/numberOfSolutions)))

# Innitial superposition of all working qubits
circuit.h(range(n-1))

# set ancilla state to |-⟩
circuit.x(n-1)
circuit.h(n-1)

circuit.barrier()

oracle(n)
circuit.append(diffuser(n), range(n))

circuit.barrier()

circuit.append(oracle(n), range(n))
circuit.append(diffuser(n), range(n))

circuit.barrier()

circuit.append(oracle(n), range(n))
circuit.append(diffuser(n), range(n))

circuit.barrier()


circuit.measure(range(n-1), range(n-1))

simulator = Aer.get_backend('qasm_simulator') #running on simulator
job = execute(circuit, backend=simulator, shots=1000)
counts = job.result().get_counts()

plot_histogram(counts)
pyplot.show()
print(circuit)
