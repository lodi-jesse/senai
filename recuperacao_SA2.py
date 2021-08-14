#Problema número 1
cont = maior = menor = aux = soma = 0 
lista = [5, 7, 2, 9, 4, 1, 3]
listaDec = []
listaCre = []

for n in lista:
    cont += 1
    soma = soma + n 
    if cont == 1:
        maior = menor = n
    else:
        if n > maior:
            maior = n
        if n < menor:
            menor = n

for i, v in enumerate(lista):
    for j, v in enumerate(lista):
        if lista[i] < lista[j]:
            aux = lista[j]
            lista[j] = lista[i]
            lista[i]= aux
for new in lista:
    listaCre.append(new)

for i, v in enumerate(lista):
    for j, v in enumerate(lista):
        if lista[i] > lista[j]:
            aux = lista[j]
            lista[j] = lista[i]
            lista[i]= aux
for new in lista:
    listaDec.append(new)

print(f'O tamanho da lista é de {cont} números')
print(f'O maior número é {maior}')
print(f'O menor número é {menor}')
print(f'A soma de todos os valores na lista é {soma}')
print(f'Lista crescente: {listaCre}')
print(f'Lista decrescente: {listaDec}')


#Problema número 2

Lista = []

for i in range(0,4):
    n = int(input(f'Digite o {i + 1}º valor: '))
    Lista.append(n)
valor = sum(Lista) / 4
print(valor)
if valor > 0:
    print(f'A média foi {valor} e o resultado é Positivo')
elif valor < 0:
    print(f'A média foi {valor} e o resultado é Negativo')

#Problema número 3

lista1 = []
tot = 0

for i in range(0,20):
    n = int(input(f'Digite o {i + 1}º valor: '))
    tot = tot + n 
    lista1.append(n)
    if i == 0:
        maior = menor = n
    else:
        if n > maior:
            maior = n
        if n < menor:
            menor = n
media = tot / 5

print(f'O maior valor foi {maior}')
print(f'O menor valor foi {menor}')
print(f'A média foi {media}')



#Problema número 4

def underline():
    under = int(input('Digite a quantidade de underline que precisa: '))
    print('_' * under)

underline()

#Problema número 5


def new_func():
    lista2 = []
    c = 0

    while True:
        n = float(input('Digite um valor: '))
        lista2.append(n)
        res = input('Deseja adicionar mais valores [S/N]: ').strip().upper()[0]
        if res == 'N':
            break

    for i in (lista2):
        c += 1
        print(f'{c} {i}')

new_func()

#Problema número 6

hora = int(input('Digite a quantidades de horas para converter em segundos: '))
s = hora * 60 * 60
print(f'Você digitou {hora} horas e convertendo em segundo vale {s}')
#Problema número 7

lista = ["    *","   * *","  *   *"," *     *","***   ***","  *   *","  *   *","  *****"]
for i in lista:
    print(i)