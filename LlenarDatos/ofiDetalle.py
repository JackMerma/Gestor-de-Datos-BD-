import random



sql = "INSERT INTO `V1M_OFICINA_DETALLE` (`OfiIde`, `OfiCiu`, `OfiReg`, `OfiDir`, `OfiEmp`, `OfiObj`, `OfiVen`, `OfiEstReg`) VALUES ({id}, 'Arequipa', 'Arequipa', '{dire}', '{empleado}', {obje}, '{venta}', 'A');"

direcciones = ["Paucarpata", "M. Melgar", "Cerro Colorado", "Yanahuara"]

objetivos = [10000, 15000, 20000, 25000]

ventas = [500, 600, 700, 800, 900, 1000]


def selectRandom(names):
  return random.choice(names)


for i in range(3,21):
    print(sql.format(id=i, dire=selectRandom(direcciones), empleado="nombre"+str(i), obje=selectRandom(objetivos), venta=selectRandom(ventas)))
