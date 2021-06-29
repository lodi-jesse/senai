#Problema número 1

L = [5, 7, 2, 9, 4, 1, 3]
print(len(L))
print(max(L))
print(min(L))
print(sum(L))
print(sorted(L))
L.sort(reverse=True)
print(L)

#Problema número 2

Lista = []

for i in range(0,4):
    n = int(input(f'Digite o {i + 1}º valor: '))
    Lista.append(n)
valor = sum(Lista) / 4
if valor >= 1:
    print('Positivo')
elif valor <= -1:
    print('Negativo')

#Problema número 3

lista1 = []

for i in range(0,20):
    n = int(input(f'Digite o {i + 1}º valor: '))
    lista1.append(n)

media = sum(lista1) / 20
print(f'A média foi de {media}')
print(f'O maior valor digitado foi {max(lista1)}')
print(f'O menor valor digitado foi {min(lista1)}')

#Problema número 4

def underline():
    under = int(input('Digite a quantidade de underline que precisa: '))
    print('_' * under)

underline()

#Problema número 5

def new_func():
    lista2 = []

    while True:
        n = float(input('Digite um valor: '))
        lista2.append(n)
        res = input('Deseja adicionar mais valores [S/N]: ').strip().upper()[0]
        if res == 'N':
            break

    for i in enumerate(lista2):
        print(i)

new_func()

#Problema número 6

hora = int(input('Digite a quantidades de horas para converter em segundos: '))
s = hora * 60 * 60

#Problema número 7

lista = ["    *","   * *","  *   *"," *     *","***   ***","  *   *","  *   *","  *****"]
for i in lista:
    print(i)