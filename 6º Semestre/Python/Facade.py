from __future__ import annotations

class Facade:
    """
    A classe Facade fornece uma interface simples para a lógica complexa de um
    ou vários subsistemas. A Facade delega as solicitações do cliente para os
    objetos apropriados dentro do subsistema. A Facade também é responsável por
    gerenciar o ciclo de vida deles. Tudo isso protege o cliente da complexidade
    indesejada do subsistema.
    """

    def __init__(self, subsystem1: Subsystem1, subsystem2: Subsystem2) -> None:
        """
        Dependendo das necessidades de sua aplicação, você pode fornecer à Facade
        objetos de subsistema existentes ou forçar a Facade a criá-los por conta
        própria.
        """

        self._subsystem1 = subsystem1 or Subsystem1()
        self._subsystem2 = subsystem2 or Subsystem2()

    def operation(self) -> str:
        """
        Os métodos da Facade são atalhos convenientes para a funcionalidade sofisticada
        dos subsistemas. No entanto, os clientes têm acesso a apenas uma fração das
        capacidades de um subsistema.
        """

        resultados = []
        resultados.append("Facade inicializa os subsistemas:")
        resultados.append(self._subsystem1.operation1())
        resultados.append(self._subsystem2.operation1())
        resultados.append("Facade ordena que os subsistemas executem a ação:")
        resultados.append(self._subsystem1.operation_n())
        resultados.append(self._subsystem2.operation_z())
        return "\n".join(resultados)


class Subsystem1:
    """
    O Subsistema pode aceitar solicitações tanto da fachada quanto diretamente do cliente.
    De qualquer forma, para o Subsistema, a Facade é apenas mais um cliente, e ela não
    faz parte do Subsistema.
    """

    def operation1(self) -> str:
        return "Subsistema1: Pronto!"

    # ...

    def operation_n(self) -> str:
        return "Subsistema1: Vai!"


class Subsystem2:
    """
    Algumas fachadas podem trabalhar com vários subsistemas ao mesmo tempo.
    """

    def operation1(self) -> str:
        return "Subsistema2: Prepare-se!"

    # ...

    def operation_z(self) -> str:
        return "Subsistema2: Fogo!"


def client_code(facade: Facade) -> None:
    """
    O código do cliente trabalha com subsistemas complexos por meio de uma interface
    simples fornecida pela Facade. Quando uma fachada gerencia o ciclo de vida do
    subsistema, o cliente pode nem mesmo saber da existência do subsistema. Essa
    abordagem permite manter a complexidade sob controle.
    """

    print(facade.operation(), end="")


if __name__ == "__main__":
    # O código do cliente pode ter alguns objetos de subsistema já criados.
    # Nesse caso, pode ser útil inicializar a Facade com esses objetos em vez
    # de permitir que a Facade crie novas instâncias.
    subsistema1 = Subsystem1()
    subsistema2 = Subsystem2()
    fachada = Facade(subsistema1, subsistema2)
    client_code(fachada)