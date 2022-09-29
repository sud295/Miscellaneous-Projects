class Equation:
    def __init__(self, point, direction):
        self.point = point
        self.direction = direction

    def __str__(self):
        return f"{self.point} + {self.direction}t"
        
    def getPoint(self, t):
        self.t = t
        return self.point + (self.t*self.direction)
