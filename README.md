
## Ações
as ações são definidas pela coluna REVTYPE da tabela que esta passando por auditoria

### Codigos da ação 
0-Add
1-Update
2-Delete


## Consultar do projeto
SELECT * FROM PRODUTO; 
SELECT * FROM PRODUTO_AUDIT ; 
SELECT * FROM REVINFO ; 

SELECT 
         (P.ID) AS ID_PRODUTO, P.DESCRICAO, P.NOME, (P.REVTYPE) AS ACAO, (INF.REVTSTMP) AS VERIFICAR_O_Q_E
 FROM 
         PRODUTO_AUDIT  AS P 
JOIN 
         REVINFO as INF ON INF.REV = P.REV;


timeStamp.toLocalDateTime().toLocalDate();         
