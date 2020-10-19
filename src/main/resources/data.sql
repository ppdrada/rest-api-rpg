insert into campanha (id, nome, descricao)
    values
        (null, 'Senhor dos Anéis', 'Destruir o Um Anel'),
        (null, 'Relíquias da Morte', 'Matar você sabe quem'),
        (null, 'Star Wars: Rogue One', 'Roubar o plano da Estrela da Morte');


insert into jogador (id, nome, categoria,  vida, ataque)
    values
        (null, 'Aragorn', 'Dunedain',7,8),
        (null, 'Gandalf', 'Mago',8,9),
        (null, 'Frodo', 'Hobbit',5,9),
        (null, 'Samwise', 'Hobbit',7,9),
        (null, 'Pippin', 'Hobbit',6,9),
        (null, 'Merry', 'Hobbit',6,9),
        (null, 'Legolas', 'Elfo',8,7),
        (null, 'Gimli', 'Anão',9,8),

        (null, 'Harry', 'Bruxo',9,7),
        (null, 'Hermione', 'Bruxa',9,6),
        (null, 'Ronald', 'Bruxo',9,5),

        (null, 'Jyn', 'Humano',8,7),
        (null, 'Cassian', 'Humano',7,8),
        (null, 'K-2S0', 'Dróide',8,9),
        (null, 'Bodhi', 'Humano',7,5),
        (null, 'Chirrut', 'Humano',8,8),
        (null, 'Jiang', 'Humano',7,7);

insert into jogador_campanha(jogador_id, campanha_id)
    values
        (1,1),
        (2,1),
        (3,1),
        (4,1),
        (5,1),
        (6,1),
        (7,1),
        (8,1),

        (9,2),
        (10,2),
        (11,2),

        (12,3),
        (13,3),
        (14,3),
        (15,3),
        (16,3),
        (17,3);

