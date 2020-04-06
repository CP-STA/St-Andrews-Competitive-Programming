from random import *

def ICY (V, s):
    # We have been given the volume V of water Yeji has, so
    # we should determine the mass of water she has, since
    # we are also given the density of water.
    water_mass = V * 100
    # Determine the volume of ice which this water mass can give.
    ice_volume = water_mass / 92
    # Determine the volume of a single ice cube of side length s.
    cube_volume = s * s * s
    # Now finally calculate the number of full ice cubes which our volume
    # of ice can be used to create.
    cube_count = ice_volume // cube_volume
    return int (cube_count)

input_list = list (map (int, input ().split ()))
print (ICY (input_list[0], input_list[1]))
