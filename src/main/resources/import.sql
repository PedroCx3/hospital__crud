
CREATE TABLE Hospital (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    endereco VARCHAR(255) NOT NULL,
    capacidade_total INT NOT NULL,
    numero_leitos_disponiveis INT NOT NULL
);


INSERT INTO Hospital (nome, endereco, capacidade_total, numero_leitos_disponiveis)
VALUES
('Hospital A', 'Rua 123, Bairro X', 200, 150),
('Hospital B', 'Avenida 456, Bairro Y', 150, 100);

CREATE TABLE Paciente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    idade INT NOT NULL,
    genero CHAR(1) NOT NULL,
    data_admissao DATE NOT NULL,
    em_quarentena BOOLEAN NOT NULL,
    hospital_id INT,
    FOREIGN KEY (hospital_id) REFERENCES Hospital(id)
);


INSERT INTO Paciente (nome, idade, genero, data_admissao, em_quarentena, hospital_id)
VALUES
('Paciente 1', 30, 'M', '2023-01-01', true, 1),
('Paciente 2', 25, 'F', '2023-01-05', false, 2);
