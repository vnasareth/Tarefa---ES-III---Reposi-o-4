# Exercício pertencente a disciplina de Engenharia de Software III

## Design Patterns

### Chain of Responsability

Implementar em Java, com camada model completa e camada de persistência para a solução do seguinte problema:

Um sistema de pagamento de funcionários que precisa cadastrar os funcionários por um ID único (INT), nome (VARCHAR(60)), salário (FLOAT). O sistema deve permitir o CRUD Completo dessa entidade e um Select ALL.
Além disso, o sistema deve ter, na camada de controle, uma forma de calcular, para posterior exibição, o desconto INSS do funcionário, que segue o seguinte padrão:

- Até R&dollar; 1.212,00 (salário-mínimo) – 7,5&percnt; do salário
- Entre R&dollar; 1. 212,00 e R&dollar; 2.427,35 – 9&percnt; da diferença
- Entre R&dollar; 2.427,36 e R&dollar; 3.641,03 – 12&percnt; da diferença
- Entre R&dollar; 3.641,03 e R&dollar; 7.087,22– 14&percnt; da diferença

**Exemplo 1:**

Se um trabalhador ganha R&dollar; 1.500,00, o desconto do INSS será de 7,5&percnt; sobre R&dollar; 1.212,00 (R&dollar; 90,90) + a alíquota de 9&percnt; sobre a quantia que está na faixa seguinte (1.500,00 – 1.212,00 = R&dollar; 288). O valor será de R&dollar; 25,92.

Cálculo final: R&dollar; 90,90 + R&dollar; 25,92 = R&dollar; 116,82

Para calcular a alíquota efetiva, divida o valor efetivo pelo salário do trabalhador (116,82 ÷ 1.500,00), o que resultará em 7,88&percnt; do seu salário.

**Exemplo 2:**

Se um trabalhador ganha R&dollar; 3.000,00, ele se encontra na terceira faixa (R&dollar; 2.427,36 e R&dollar; 3.641,03). Será necessário calcular o valor da alíquota para cada faixa:

1ª faixa salarial: 1.212,00 x 7,5&percnt; = 90,90

2ª faixa salarial: [2.427,35 – 1.212,00] x 9&percnt; = 1.215,35 x 9% = 109,38

Faixa que atinge o salário: [3.000,00 – 2.427,35] x 12&percnt; = 572,65 x 12% = 68,71

Total a recolher: 90,90 + 109,38 + 68,71 = 268,99

O desconto do INSS tem um teto de contribuição, que é de R&dollar; 7.087,22. Além disso, é importante destacar que os ajustes também valem para empregados domésticos e trabalhadores avulsos.
