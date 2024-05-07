# Sistema de Reserva e Controle de Quartos em um Hotel

Este é um sistema simples desenvolvido em Java que simula um sistema de reserva e controle de quartos em um hotel, utilizando threads para representar as diferentes entidades do sistema.

## Funcionalidades

O sistema conta com as seguintes entidades:

- **Quarto**: Representa um quarto no hotel.
- **Hóspede**: Cada hóspede é representado por uma thread.
- **Camareira**: Cada camareira é representada por uma thread.
- **Recepcionista**: Cada recepcionista é representado por uma thread.

## Regras de Funcionamento

O sistema segue as seguintes regras:

- Os hóspedes são alocados apenas em quartos vagos.
- Cada quarto possui capacidade para até 4 hóspedes e uma única chave.
- Grupos ou famílias com mais de 4 membros são divididos em vários quartos.
- Os hóspedes devem deixar a chave na recepção ao saírem do hotel.
- Uma camareira só pode limpar um quarto se ele estiver vago ou os hóspedes não estiverem presentes.
- A limpeza dos quartos é feita sempre após a saída dos hóspedes.
- Quartos que passam por limpeza não podem ser alocados para novos hóspedes imediatamente.
- Se um hóspede chega e não há quartos vagos, ele deve esperar em uma fila.
- Se um hóspede tenta alugar um quarto duas vezes sem sucesso, ele deixa uma reclamação e vai embora.

## Como Executar o Sistema

Para executar o sistema, basta compilar todos os arquivos `.java` e executar o arquivo `Main.java`.

```bash
javac *.java
java Main
```
