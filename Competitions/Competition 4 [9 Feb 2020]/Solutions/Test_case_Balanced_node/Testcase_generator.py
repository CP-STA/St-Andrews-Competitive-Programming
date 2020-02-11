from binarytree import build


l = [-1,5,1,0,None,-1,0,3,5,None,None,None,None,4,-2,4]
root = build(l)
print(root)

f = open("input0.txt", "w")
for i in l:
    if i == None:
        f.write("null ")
    else:
        f.write(str(i) + " ")
    
f.close()