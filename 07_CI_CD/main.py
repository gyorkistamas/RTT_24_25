import math

class EgyenletMegoldo:
	def masodfoku_egyenlet_megoldo(self, a, b, c):
		if (type(a) not in [int, float] or type(b) not in [int, float] or type(c) not in [int, float]):
			raise TypeError("Csak számok lehetnek!")
		
		d = math.pow(b, 2) - (4 * a * c)

		if (d < 0):
			return None, None
		
		return (-b + math.sqrt(d)) / 2 * a, (-b - math.sqrt(d)) / 2 * a
	
	def feladatmegoldo(self, a, b, c):
		x1, x2 = self.masodfoku_egyenlet_megoldo(a, b, c)

		print(f"{a}^2 + {b}x + {c} = 0")

		if x1 is None and x2 is None:
			print("Nincs megoldás")
		elif x1 == x2:
			print(f"Egy megoldás: {x1}")
		else:
			print(f"Kettő megoldás: {x1}, {x2}")