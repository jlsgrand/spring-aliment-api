import csv

#############################
###### Aliments Class #######
#############################

sql_file = open('./data.sql', 'w')


aliments_filename = './aliments.csv'

# Première lecture pour les classes d'aliments
aliment_classes = {}

with open(aliments_filename) as csv_file:
    csv_reader = csv.reader(csv_file, delimiter=';')
    line_count = 0
    aliment_class_id = 1
    for row in csv_reader:
        # On ignore la première ligne d'en-tête.
        if line_count != 0:
            aliment_class_name = row[1].strip()

            if aliment_class_name not in aliment_classes:
                aliment_classes[aliment_class_name] = aliment_class_id
                sql_file.write(
                    f'insert into aliment_class (id, name) values (aliment_class_id_seq.nextval, \'{aliment_class_name}\');\n')
                aliment_class_id += 1

        line_count += 1

with open(aliments_filename) as csv_file:
    csv_reader = csv.reader(csv_file, delimiter=';')
    line_count = 0
    for row in csv_reader:
        # On ignore la première ligne d'en-tête.
        if line_count != 0:
            aliment_class_name = row[1].strip()
            aliment_name = row[3].strip().replace('\'', '\'\'')
            aliment_energy = row[4].strip().replace(',', '.')
            aliment_water = row[5].strip().replace(',', '.')
            aliment_prots = row[6].strip().replace(',', '.')
            aliment_carbs = row[7].strip().replace(',', '.')
            aliment_lipids = row[8].strip().replace(',', '.')
            aliment_sugars = row[9].strip().replace(',', '.')
            aliment_fibers = row[10].strip().replace(',', '.')

            aliment_class_id = aliment_classes[aliment_class_name]

            sql_file.write(
                f'insert into aliment (id, aliment_class_id, name, energy, water, proteins, carbs, lipids, sugars, fibers) values' \
                f' (aliment_id_seq.nextval, \'{aliment_class_id}\', \'{aliment_name}\', {aliment_energy}, {aliment_water},'
                f' {aliment_prots}, {aliment_carbs}, {aliment_lipids}, {aliment_sugars}, {aliment_fibers});\n')

        line_count += 1
