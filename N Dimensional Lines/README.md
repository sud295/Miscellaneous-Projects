# N Dimensional Lines
User inputs points in N dimensions.
Points are converted to vector-based equations of lines.
If points are 2D or 3D, lines are plotted.

## Example: 
```
Dimension? 3
Enter coordinate 1: 1
Enter coordinate 2: 3
Enter coordinate 3: 4
NEXT

Enter coordinate 1: 1
Enter coordinate 2: 6
Enter coordinate 3: 5
NEXT

Enter coordinate 1: 3
Enter coordinate 2: 4
Enter coordinate 3: 2
NEXT

Enter coordinate 1: 7
Enter coordinate 2: 5
Enter coordinate 3: 6
NEXT

Enter coordinate 1: 3
Enter coordinate 2: 9
Enter coordinate 3: 7
NEXT

Enter coordinate 1: b
NEXT

[1. 3. 4.] + [0. 3. 1.]t  r(0) =  [1. 3. 4.]  r(1) =  [1. 6. 5.]
[1. 6. 5.] + [ 2. -2. -3.]t  r(0) =  [1. 6. 5.]  r(1) =  [3. 4. 2.]
[3. 4. 2.] + [4. 1. 4.]t  r(0) =  [3. 4. 2.]  r(1) =  [7. 5. 6.]
[7. 5. 6.] + [-4.  4.  1.]t  r(0) =  [7. 5. 6.]  r(1) =  [3. 9. 7.]

Define Line Points?: y
Show?: y
```

![Figure_1](https://user-images.githubusercontent.com/69227764/202863163-c916b945-e626-4d49-83d6-047e2ad34145.png)
