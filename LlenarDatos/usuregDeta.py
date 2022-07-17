import random



sql = "INSERT INTO `V4M_USUARIO_REGISTRADOS_DETALLE` (`UsuRegDetIde`, `UsuRegDetUsu`, `UsuRegDetPass`, `UsuRegEstReg`) VALUES ({id}, '{username}', '{passw}', 'A');"

direcciones = ["Paucarpata", "M. Melgar", "Cerro Colorado", "Yanahuara"]

objetivos = [10000, 15000, 20000, 25000]

ventas = [500, 600, 700, 800, 900, 1000]


def selectRandom(names):
  return random.choice(names)


f = open("usuregDeta.sql", "w")

try:
  for i in range(3,21):
    f.write(sql.format(id=i, username="nombre"+str(i), passw="nombre"+str(i)))
finally:
  f.close()



