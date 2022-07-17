import random

sql = "INSERT INTO `V1T_PRODUCTO_DETALLE` (`ProDetIde`, `ProDetFab`, `ProDetDes`, `ProDetPre`, `ProDetExi`, `ProDetClaABC`, `ProDetUni`, `ProDetStoAct`, `ProDetStoMin`, `ProDetStoMax`, `ProDetEstReg`) VALUES ({ide}, '{fab}', '{des}', {precio}, {exis}, '{cla}', 'unidad', {act}, '1', {max}, 'A');"

exi = [150, 200, 250, 300, 350]
prec = [5.50, 10.20, 15.50, 3.20, 7.50, 10.50, 4.50, 4.20]
clase = ["A", "B", "C"]
descrip = ["cartuchera", "libro", "folder", "estuche colores", "Escuadras", "cuaderno", "lapicero"]


# Regresa un item a azar de la lista 'name


def selectRandom(names):
    return random.choice(names)


# nombre del archivo
f = open("LlenarDatos/ProDet.sql", "w")

# intentando escribir en ese archivo
try:
    for i in range(3, 21):
        f.write(sql.format(ide=i, fab="fab"+str(i), des=selectRandom(descrip), precio=selectRandom(prec), exis=selectRandom(exi), cla=selectRandom(clase), act=selectRandom(exi), max=selectRandom(exi)))
finally:
    f.close()
