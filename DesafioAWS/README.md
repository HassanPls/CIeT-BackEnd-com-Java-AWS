# RELATÓRIO DE IMPLEMENTAÇÃO DE SERVIÇOS AWS

**Data:** 27/02/2026

**Empresa:** Abstergo Industries 

**Responsável:** Pedro Luiz

## Introdução
Este relatório apresenta o processo de implementação de ferramentas na empresa Abstergo Industries, realizado por Pedro Luiz. O objetivo do projeto foi elencar 3 serviços AWS, com a finalidade de realizar diminuição de custos imediatos.

## Descrição do Projeto
O projeto de implementação de ferramentas foi dividido em 3 etapas, cada uma com seus objetivos específicos. A seguir, serão descritas as etapas do projeto:

Etapa 1: 
- S3 Intelligent-Tiering
- Gerenciar de forma automática o padrão de acesso do armazenamento
- Implementação da classe de armazenamento S3 Intelligent-Tiering para dados com padrões de acesso desconhecidos ou variáveis (como data lakes e análises). A ferramenta monitora os padrões de acesso e move automaticamente objetos não acessados para níveis de armazenamento de menor custo (Infrequent Access e Archive Instant Access), sem impacto na performance e com taxa fixa reduzida de automação. Isso elimina a necessidade de intervenção manual e garante economia automática.

Etapa 2: 
- EC2 Rightsizing com Lambda
- Otimizar a capacidade computacional
- Criação de uma automação serverless com AWS Lambda que analisa periodicamente as métricas de utilização de instâncias EC2 via Amazon CloudWatch. A função Lambda identifica instâncias superdimensionadas (com baixo uso de CPU/memória) e gera recomendações de redimensionamento para tipos de instância menores e mais baratos, ou executa a alteração automaticamente fora do horário comercial, resultando em redução de custos de computação.

Etapa 3: 
- Amazon CloudWatch
- Facilitar o monitoramento de métricas
- Configuração de dashboards e alarmes no CloudWatch para monitorar continuamente a utilização de recursos (EC2, S3, etc.) e identificar padrões de desperdício. Através da coleta de métricas detalhadas, a equipe de operações pode visualizar recursos ociosos, picos de demanda e tendências de uso, permitindo ações proativas de otimização (como desligar instâncias não utilizadas) e garantindo que os investimentos em infraestrutura estejam alinhados com a real necessidade.

## Conclusão
A implementação de ferramentas na empresa *Abstergo Industries tem como esperado localizar custos adicionais e diminui-los de forma automática*, o que aumentará a eficiência e a produtividade da empresa. Recomenda-se a continuidade da utilização das ferramentas implementadas e a busca por novas tecnologias que possam melhorar ainda mais os processos da empresa.

## Anexos

- [S3 Intelligent-Tiering](https://docs.aws.amazon.com/pt_br/AmazonS3/latest/userguide/intelligent-tiering.html)
- [EC2 Rightsizing com Lambda](https://docs.aws.amazon.com/cost-management/latest/userguide/cost-optimization-hub.html)
- [Amazon CloudWatch](https://docs.aws.amazon.com/pt_br/AmazonCloudWatch/latest/monitoring/WhatIsCloudWatch.html)

Assinatura do Responsável pelo Projeto:
Pedro Luiz