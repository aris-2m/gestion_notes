-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : dim. 25 déc. 2022 à 22:21
-- Version du serveur : 10.4.25-MariaDB
-- Version de PHP : 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gestion_notes`
--

-- --------------------------------------------------------

--
-- Structure de la table `account`
--

CREATE TABLE `account` (
  `idAccount` int(10) UNSIGNED NOT NULL,
  `password` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `account`
--

INSERT INTO `account` (`idAccount`, `password`) VALUES
(1, '1234'),
(2, '1234'),
(3, '1234'),
(4, '1234');

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

CREATE TABLE `admin` (
  `idPerson` int(10) UNSIGNED NOT NULL,
  `fkAccount` int(10) UNSIGNED NOT NULL,
  `name` varchar(40) NOT NULL,
  `surname` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `admin`
--

INSERT INTO `admin` (`idPerson`, `fkAccount`, `name`, `surname`) VALUES
(1, 1, 'Aris', 'MONKOUN'),
(2, 2, 'Teddy', 'GUIDIBI'),
(3, 3, 'Abdoul', 'AMIDOU'),
(4, 4, 'Mohamed', 'NASRI');

-- --------------------------------------------------------

--
-- Structure de la table `evaluation`
--

CREATE TABLE `evaluation` (
  `idEvaluation` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `evaluation`
--

INSERT INTO `evaluation` (`idEvaluation`) VALUES
(1),
(2),
(3),
(4);

-- --------------------------------------------------------

--
-- Structure de la table `evaluation_cc`
--

CREATE TABLE `evaluation_cc` (
  `idEvaluation` int(10) UNSIGNED NOT NULL,
  `mark` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `evaluation_cc`
--

INSERT INTO `evaluation_cc` (`idEvaluation`, `mark`) VALUES
(1, 17);

-- --------------------------------------------------------

--
-- Structure de la table `evaluation_map`
--

CREATE TABLE `evaluation_map` (
  `idEvaluationMap` int(10) UNSIGNED NOT NULL,
  `fkEvaluation` int(10) UNSIGNED NOT NULL,
  `fkStudent` int(10) UNSIGNED NOT NULL,
  `fkModule` int(10) UNSIGNED NOT NULL,
  `evalWeight` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `evaluation_map`
--

INSERT INTO `evaluation_map` (`idEvaluationMap`, `fkEvaluation`, `fkStudent`, `fkModule`, `evalWeight`) VALUES
(1, 2, 1, 2, 0.3),
(2, 3, 1, 3, 0.3),
(3, 4, 1, 1, 0.4);

-- --------------------------------------------------------

--
-- Structure de la table `evaluation_project`
--

CREATE TABLE `evaluation_project` (
  `idEvaluation` int(10) UNSIGNED NOT NULL,
  `mark` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `evaluation_project`
--

INSERT INTO `evaluation_project` (`idEvaluation`, `mark`) VALUES
(4, 20);

-- --------------------------------------------------------

--
-- Structure de la table `evaluation_tp`
--

CREATE TABLE `evaluation_tp` (
  `idEvaluation` int(10) UNSIGNED NOT NULL,
  `mark` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `evaluation_tp`
--

INSERT INTO `evaluation_tp` (`idEvaluation`, `mark`) VALUES
(2, 18),
(3, 19);

-- --------------------------------------------------------

--
-- Structure de la table `fieldofstudy`
--

CREATE TABLE `fieldofstudy` (
  `idFieldOfStudy` int(10) UNSIGNED NOT NULL,
  `name` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `fieldofstudy`
--

INSERT INTO `fieldofstudy` (`idFieldOfStudy`, `name`) VALUES
(1, 'IID'),
(2, 'GI');

-- --------------------------------------------------------

--
-- Structure de la table `module`
--

CREATE TABLE `module` (
  `idModule` int(10) UNSIGNED NOT NULL,
  `fkProf` int(11) UNSIGNED NOT NULL,
  `fkFieldOfStudy` int(11) UNSIGNED NOT NULL,
  `moduleName` varchar(40) NOT NULL,
  `moduleWeight` float NOT NULL,
  `semester` int(11) NOT NULL,
  `sumSubWeights` float NOT NULL,
  `idRootModule` int(10) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `module`
--

INSERT INTO `module` (`idModule`, `fkProf`, `fkFieldOfStudy`, `moduleName`, `moduleWeight`, `semester`, `sumSubWeights`, `idRootModule`) VALUES
(1, 4, 1, 'Software Process', 1, 1, 0, NULL),
(2, 4, 1, 'Software Process - Design Patterns', 0.5, 1, 0, 1),
(3, 4, 1, 'Software Process - Tests', 0.5, 1, 0, 1);

-- --------------------------------------------------------

--
-- Structure de la table `module_mark`
--

CREATE TABLE `module_mark` (
  `idMark` int(10) UNSIGNED NOT NULL,
  `fkModule` int(10) UNSIGNED NOT NULL,
  `fkStudent` int(10) UNSIGNED NOT NULL,
  `mark` float NOT NULL,
  `state` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `module_mark`
--

INSERT INTO `module_mark` (`idMark`, `fkModule`, `fkStudent`, `mark`, `state`) VALUES
(1, 1, 1, 19.1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `person`
--

CREATE TABLE `person` (
  `idPerson` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `person`
--

INSERT INTO `person` (`idPerson`) VALUES
(1),
(2),
(3),
(4);

-- --------------------------------------------------------

--
-- Structure de la table `prof`
--

CREATE TABLE `prof` (
  `idPerson` int(10) UNSIGNED NOT NULL,
  `fkAccount` int(11) UNSIGNED NOT NULL,
  `name` varchar(40) NOT NULL,
  `surname` varchar(40) NOT NULL,
  `code` varchar(40) NOT NULL,
  `speciality` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `prof`
--

INSERT INTO `prof` (`idPerson`, `fkAccount`, `name`, `surname`, `code`, `speciality`) VALUES
(4, 4, 'Mohamed', 'NASRI', 'ENSAPROF1', 'Software Process');

-- --------------------------------------------------------

--
-- Structure de la table `student`
--

CREATE TABLE `student` (
  `idPerson` int(10) UNSIGNED NOT NULL,
  `fkAccount` int(11) UNSIGNED NOT NULL,
  `fkFieldOfStudy` int(11) UNSIGNED NOT NULL,
  `name` varchar(40) NOT NULL,
  `surname` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `student`
--

INSERT INTO `student` (`idPerson`, `fkAccount`, `fkFieldOfStudy`, `name`, `surname`) VALUES
(1, 1, 2, 'Aris', 'MONKOUN'),
(2, 2, 1, 'Teddy', 'GUIDIBI'),
(3, 3, 1, 'Abdoul', 'AMIDOU');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`idAccount`);

--
-- Index pour la table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`idPerson`),
  ADD KEY `fkAccountAdmin` (`fkAccount`);

--
-- Index pour la table `evaluation`
--
ALTER TABLE `evaluation`
  ADD PRIMARY KEY (`idEvaluation`);

--
-- Index pour la table `evaluation_cc`
--
ALTER TABLE `evaluation_cc`
  ADD KEY `fkEvaluationEvaluationCC` (`idEvaluation`);

--
-- Index pour la table `evaluation_map`
--
ALTER TABLE `evaluation_map`
  ADD PRIMARY KEY (`idEvaluationMap`),
  ADD KEY `fkEvaluationEvaluationMap` (`fkEvaluation`),
  ADD KEY `fkModuleEvaluationMap` (`fkModule`),
  ADD KEY `fkStudentEvaluationMap` (`fkStudent`);

--
-- Index pour la table `evaluation_project`
--
ALTER TABLE `evaluation_project`
  ADD PRIMARY KEY (`idEvaluation`);

--
-- Index pour la table `evaluation_tp`
--
ALTER TABLE `evaluation_tp`
  ADD KEY `fkEvaluationEvaluationTP` (`idEvaluation`);

--
-- Index pour la table `fieldofstudy`
--
ALTER TABLE `fieldofstudy`
  ADD PRIMARY KEY (`idFieldOfStudy`);

--
-- Index pour la table `module`
--
ALTER TABLE `module`
  ADD PRIMARY KEY (`idModule`),
  ADD KEY `fkProfModule` (`fkProf`),
  ADD KEY `fkModuleSubModule` (`idRootModule`),
  ADD KEY `fkFieldOfStudyModule` (`fkFieldOfStudy`);

--
-- Index pour la table `module_mark`
--
ALTER TABLE `module_mark`
  ADD PRIMARY KEY (`idMark`),
  ADD KEY `fkModuleMark` (`fkModule`),
  ADD KEY `fkStudentModuleMark` (`fkStudent`);

--
-- Index pour la table `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`idPerson`);

--
-- Index pour la table `prof`
--
ALTER TABLE `prof`
  ADD PRIMARY KEY (`idPerson`),
  ADD KEY `fkAccountProf` (`fkAccount`);

--
-- Index pour la table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`idPerson`),
  ADD KEY `fkAccountStudent` (`fkAccount`),
  ADD KEY `fkFieldOfStudyStudent` (`fkFieldOfStudy`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `account`
--
ALTER TABLE `account`
  MODIFY `idAccount` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `evaluation`
--
ALTER TABLE `evaluation`
  MODIFY `idEvaluation` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `evaluation_map`
--
ALTER TABLE `evaluation_map`
  MODIFY `idEvaluationMap` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `evaluation_project`
--
ALTER TABLE `evaluation_project`
  MODIFY `idEvaluation` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `fieldofstudy`
--
ALTER TABLE `fieldofstudy`
  MODIFY `idFieldOfStudy` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `module`
--
ALTER TABLE `module`
  MODIFY `idModule` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `module_mark`
--
ALTER TABLE `module_mark`
  MODIFY `idMark` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `person`
--
ALTER TABLE `person`
  MODIFY `idPerson` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `fkAccountAdmin` FOREIGN KEY (`fkAccount`) REFERENCES `account` (`idAccount`),
  ADD CONSTRAINT `fkPersonAdmin` FOREIGN KEY (`idPerson`) REFERENCES `person` (`idPerson`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `evaluation_cc`
--
ALTER TABLE `evaluation_cc`
  ADD CONSTRAINT `fkEvaluationEvaluationCC` FOREIGN KEY (`idEvaluation`) REFERENCES `evaluation` (`idEvaluation`);

--
-- Contraintes pour la table `evaluation_map`
--
ALTER TABLE `evaluation_map`
  ADD CONSTRAINT `fkEvaluationEvaluationMap` FOREIGN KEY (`fkEvaluation`) REFERENCES `evaluation` (`idEvaluation`),
  ADD CONSTRAINT `fkModuleEvaluationMap` FOREIGN KEY (`fkModule`) REFERENCES `module` (`idModule`),
  ADD CONSTRAINT `fkStudentEvaluationMap` FOREIGN KEY (`fkStudent`) REFERENCES `student` (`idPerson`);

--
-- Contraintes pour la table `evaluation_project`
--
ALTER TABLE `evaluation_project`
  ADD CONSTRAINT `fkEvaluationEvaluationProject` FOREIGN KEY (`idEvaluation`) REFERENCES `evaluation` (`idEvaluation`);

--
-- Contraintes pour la table `evaluation_tp`
--
ALTER TABLE `evaluation_tp`
  ADD CONSTRAINT `fkEvaluationEvaluationTP` FOREIGN KEY (`idEvaluation`) REFERENCES `evaluation` (`idEvaluation`);

--
-- Contraintes pour la table `module`
--
ALTER TABLE `module`
  ADD CONSTRAINT `fkFieldOfStudyModule` FOREIGN KEY (`fkFieldOfStudy`) REFERENCES `fieldofstudy` (`idFieldOfStudy`),
  ADD CONSTRAINT `fkModuleSubModule` FOREIGN KEY (`idRootModule`) REFERENCES `module` (`idModule`),
  ADD CONSTRAINT `fkProfModule` FOREIGN KEY (`fkProf`) REFERENCES `prof` (`idPerson`);

--
-- Contraintes pour la table `module_mark`
--
ALTER TABLE `module_mark`
  ADD CONSTRAINT `fkModuleMark` FOREIGN KEY (`fkModule`) REFERENCES `module` (`idModule`),
  ADD CONSTRAINT `fkStudentModuleMark` FOREIGN KEY (`fkStudent`) REFERENCES `student` (`idPerson`);

--
-- Contraintes pour la table `prof`
--
ALTER TABLE `prof`
  ADD CONSTRAINT `fkAccountProf` FOREIGN KEY (`fkAccount`) REFERENCES `account` (`idAccount`),
  ADD CONSTRAINT `fkPersonProf` FOREIGN KEY (`idPerson`) REFERENCES `person` (`idPerson`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `fkAccountStudent` FOREIGN KEY (`fkAccount`) REFERENCES `account` (`idAccount`),
  ADD CONSTRAINT `fkFieldOfStudyStudent` FOREIGN KEY (`fkFieldOfStudy`) REFERENCES `fieldofstudy` (`idFieldOfStudy`),
  ADD CONSTRAINT `fkPersonStudent` FOREIGN KEY (`idPerson`) REFERENCES `person` (`idPerson`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
