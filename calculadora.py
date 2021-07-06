import os

def calcular(troco):
    if troco / 100:
        quant100 = int(troco // 100)
        resto100 = troco - (quant100 * 100)
        if quant100 > 0:
            print(f'{quant100} Nota: R$100,00')
    if resto100 != 0:
        quant50 = int(resto100 // 50)
        resto50 = resto100 - (quant50 * 50)
        if quant50 > 0:
            print(f'{quant50} Nota: R$50,00')
        if resto50 != 0:
            quant20 = int(resto50 // 20) 
            resto20 = resto50 - (quant20 * 20)
            if quant20 > 0:
                print(f'{quant20} Nota: R$20,00')
            if resto20 != 0:
                quant10 = int(resto20 // 10)
                resto10 = resto20 - (quant10 * 10)
                if quant10 > 0:
                    print(f'{quant10} Nota: R$10,00')
                if resto10 != 0:
                    quant5 = int(resto10 // 5)
                    resto5 = resto10 - (quant5 * 5)
                    if quant5 > 0:
                        print(f'{quant5} Nota: R$5,00')
                    if resto5 != 0:
                        quant2 = int(resto5 // 2)
                        resto2 = resto5 - (quant2 * 2)
                        if quant2 > 0:
                            print(f'{quant2} Nota: R$2,00')
                        if resto2 != 0:
                            quant1 = int(resto2 // 1)
                            resto1 = resto2 - (quant1 * 1)
                            if quant1 > 0:
                                print(f'{quant1} Moeda: R$1,00')
                            if resto1 != 0:
                                quant050 = int(resto1 // 0.50)
                                resto050 = resto1 - (quant050 * 0.50)
                                if quant050 > 0:
                                    print(f'{quant050} Moeda: R$0,50')
                                if resto050 != 0:
                                    quant025 = int(resto050 // 0.25)
                                    resto025 = resto050 - (quant025 * 0.25)
                                    if quant025 > 0:
                                        print(f'{quant025} Moeda: R$0,25')
                                    if resto025 != 0:
                                        quant010 = int(resto025 // 0.10)
                                        resto010 = resto025 - (quant010 * 0.10)
                                        if quant010 > 0:
                                            print(f'{quant010} Moeda: R$0,10')
                                        if resto010 != 0:
                                            quant005 = int(resto010 // 0.05)
                                            resto005 = resto010 - (quant005 * 0.05)
                                            if quant005 > 0:
                                                print(f'{quant005} Moeda: R$0,05')
                                            if resto005 != 0:
                                                quant001 = int(resto005 // 0.01)
                                                if quant001 > 0:
                                                    print(f'{quant001} Moeda: R$0,01')

quant100 = quant50 = quant20 = quant10 = quant5 = quant2 = 0
quant1 = quant050 = quant025 = quant010 = quant005 = 0  

def valor_compra(msg):
    while True:
        try:
            compra = float(input(msg))
        except(ValueError,TypeError):
            print('ERRO! digite ponto(.) no lugar da virgula(,)')
        else:
            return compra

def valor_receber(msg):
    while True:
        try:
            recebe = float(input(msg))
        except(ValueError,TypeError):
            print('ERRO! digite ponto(.) no lugar da virgula(,)')
        else:
            return recebe


os.system('cls')
compra = valor_compra('Valor total das compras: R$')
recebe = valor_receber('Valor recebido: R$')
troco = recebe - compra
print(f'Troco: R${round(troco,2)}')
print('='*35)
calcular(troco)
