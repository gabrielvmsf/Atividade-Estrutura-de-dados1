class Lavagem:
    '''Subsistema # 1'''

    def lavar(self):
        print("Lavando...")

class Enxague:
    '''Subsistema # 2'''

    def enxaguar(self):
        print("Enxaguando...")

class Centrifugacao:
    '''Subsistema # 3'''

    def centrifugar(self):
        print("Centrifugando...")

class MaquinaDeLavarRoupa:
    '''Fachada'''

    def __init__(self):
        self.lavagem = Lavagem()
        self.enxague = Enxague()
        self.centrifugacao = Centrifugacao()

    def iniciarLavagem(self):
        self.lavagem.lavar()
        self.enxague.enxaguar()
        self.centrifugacao.centrifugar()

""" Método principal """
if __name__ == "__main__":

    maquinaDeLavar = MaquinaDeLavarRoupa()
    maquinaDeLavar.iniciarLavagem()