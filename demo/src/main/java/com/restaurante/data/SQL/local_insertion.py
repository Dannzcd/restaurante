import psycopg2
import json

connection = psycopg2.connect(
    database="Restaurante",
    user="postgres",
    password="M@caco1234",
    host="localhost",
    port="5432"
)

cursor = connection.cursor()

json_estados_cidades = None
capitais = (
    "Rio Branco",
    "Maceió",
    "Manaus",
    "Macapá",
    "Salvador",
    "Fortaleza",
    "Brasília",
    "Vitória",
    "Goiânia",
    "São Luís",
    "Belo Horizonte",
    "Campo Grande",
    "Cuiabá",
    "Belém",
    "João Pessoa",
    "Recife",
    "Teresina",
    "Curitiba",
    "Rio de Janeiro",
    "Natal",
    "Porto Velho",
    "Boa Vista",
    "Porto Alegre",
    "Florianópolis",
    "Aracaju",
    "São Paulo",
    "Palmas"
)


with open('json_backups/cidade_estado.json') as data_file1:
    json_estados_cidades = json.load(data_file1)


INSERT_query2 = "INSERT INTO Estado_br(nome, sigla) VALUES('{}', '{}')"

INSERT_query3 = "INSERT INTO {}(nome, is_capital, estado_id) VALUES('{}', {}, {})"

for estado in json_estados_cidades["estados"]:
    cursor.execute(INSERT_query2.format(estado["nome"], estado["sigla"]))
    connection.commit()

index_estado = 0
index_cidade = 0
is_capital = False

for estado in json_estados_cidades["estados"]:
    for cidade in json_estados_cidades["estados"][index_estado]["cidades"]:
        if (cidade == capitais[index_estado]):
            is_capital = True
        
        cursor.execute(INSERT_query3.format("Cidade_br", cidade, is_capital, index_estado+1))
        connection.commit()
        is_capital = False
        index_cidade += 1
    index_estado += 1

index = None
index_estado = None
print("Operação concluída com sucesso")