# Blocos personalizados do Kix

Um bloco Lua portátil é um arquivo JSON com a extensão `.kixblock.json`. Copie ou importe o arquivo para a pasta `libs` de um projeto e abra o projeto novamente. O Kix registra o bloco na categoria de blocos personalizados.

```json
{
  "format": "kix-custom-block",
  "version": 1,
  "id": "show_score",
  "kind": "text",
  "header": "mostrar pontuação {1}",
  "parameters": [
    { "name": "score", "type": "text" }
  ],
  "lua": "print('Pontuação: ' .. score)"
}
```

## Regras do formato

- `id` e o `name` de cada parâmetro precisam começar com uma letra e podem conter letras, números, `_` e `-`.
- O cabeçalho pode ter até 80 caracteres e usar marcadores `{1}`, `{2}`, etc. para os parâmetros.
- São aceitos no máximo oito parâmetros por bloco.
- `kind` organiza o bloco como `basic`, `text`, `shader`, `camera`, `preset`, `three_d` ou `custom`.
- Os tipos portáteis de parâmetro são `text`, `number`, `boolean`, `color`, `file`, `object_id` e `shader_source`. Todos aceitam fórmulas, para que valores sejam calculados durante a execução.
- `lua` é executado pelo LuaJ. Os parâmetros são disponibilizados como variáveis Lua em texto e o objeto atual fica disponível como `sprite`.
- Não importe arquivos de pessoas em quem você não confia: o arquivo contém código executável.

Para compartilhar ou exportar, copie o mesmo arquivo `.kixblock.json` da pasta `libs` do projeto. O formato contém tudo de que o bloco precisa e não depende de um arquivo XML de biblioteca.
