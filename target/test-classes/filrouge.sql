drop table if exists COMPETITION;

drop table if exists EQUIPE;

drop table if exists JOUER;

drop table if exists PHASE_FINALE;

drop table if exists POSSEDER;

drop table if exists POULE;

drop table if exists PRONOSTIQUER;

drop table if exists RENCONTRE;

drop table if exists ROLE;

drop table if exists USER;

/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `filrouge`
--

-- --------------------------------------------------------

--
-- Structure de la table `competition`
--

CREATE TABLE `competition` (
  `ID_COMPETITION` int(11) NOT NULL,
  `DATE_DEBUT` date DEFAULT NULL,
  `DATE_FIN` date DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `competition`
--

INSERT INTO `competition` (`ID_COMPETITION`, `DATE_DEBUT`, `DATE_FIN`) VALUES
(1, '2017-03-01', '2017-03-31');

-- --------------------------------------------------------

--
-- Structure de la table `equipe`
--

CREATE TABLE `equipe` (
  `ID_EQUIPE` int(11) NOT NULL,
  `PAYS` varchar(15) DEFAULT NULL,
  `id_poule` int(11) DEFAULT NULL,
  `id_phase_finale` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `equipe`
--

INSERT INTO `equipe` (`ID_EQUIPE`, `PAYS`, `id_poule`, `id_phase_finale`) VALUES
(1, 'France', 1, NULL),
(2, 'Portugal', 1, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `jouer`
--

CREATE TABLE `jouer` (
  `ID_EQUIPE` int(11) NOT NULL,
  `ID_RENCONTRE` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `jouer`
--

INSERT INTO `jouer` (`ID_EQUIPE`, `ID_RENCONTRE`) VALUES
(1, 1),
(2, 1);

-- --------------------------------------------------------

--
-- Structure de la table `phase_finale`
--

CREATE TABLE `phase_finale` (
  `ID_PHASE_FINALE` int(11) NOT NULL,
  `ID_COMPETITION` int(11) NOT NULL,
  `TYPE` varchar(10) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `posseder`
--

CREATE TABLE `posseder` (
  `ID_USER` int(11) NOT NULL,
  `ID_ROLE` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `posseder`
--

INSERT INTO `posseder` (`ID_USER`, `ID_ROLE`) VALUES
(1, 2);

-- --------------------------------------------------------

--
-- Structure de la table `poule`
--

CREATE TABLE `poule` (
  `ID_POULE` int(11) NOT NULL,
  `ID_COMPETITION` int(11) NOT NULL,
  `CODE` char(1) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `poule`
--

INSERT INTO `poule` (`ID_POULE`, `ID_COMPETITION`, `CODE`) VALUES
(1, 1, 'A');

-- --------------------------------------------------------

--
-- Structure de la table `pronostiquer`
--

CREATE TABLE `pronostiquer` (
  `ID_USER` int(11) NOT NULL,
  `ID_RENCONTRE` int(11) NOT NULL,
  `SCOREEQUIPEA` int(11) NOT NULL,
  `SCOREEQUIPEB` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `rencontre`
--

CREATE TABLE `rencontre` (
  `ID_RENCONTRE` int(11) NOT NULL,
  `ID_PHASE_FINALE` int(11) DEFAULT NULL,
  `ID_POULE` int(11) DEFAULT NULL,
  `DATE` date DEFAULT NULL,
  `SCOREEQUIPEA` int(11) DEFAULT NULL,
  `SCOREEQUIPEB` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `rencontre`
--

INSERT INTO `rencontre` (`ID_RENCONTRE`, `ID_PHASE_FINALE`, `ID_POULE`, `DATE`, `SCOREEQUIPEA`, `SCOREEQUIPEB`) VALUES
(1, NULL, 1, '2017-03-09', 2, 3);

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

CREATE TABLE `role` (
  `ID_ROLE` int(11) NOT NULL,
  `TYPE` varchar(10) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `role`
--

INSERT INTO `role` (`ID_ROLE`, `TYPE`) VALUES
(1, 'admin'),
(2, 'user');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `ID_USER` int(11) NOT NULL,
  `USERNAME` varchar(50) DEFAULT NULL,
  `PASSWORD` varchar(50) DEFAULT NULL,
  `POINTS` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `user`
--

INSERT INTO `user` (`ID_USER`, `USERNAME`, `PASSWORD`, `POINTS`) VALUES
(1, 'layla', 'laylaitby', 0);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `competition`
--
ALTER TABLE `competition`
  ADD PRIMARY KEY (`ID_COMPETITION`);

--
-- Index pour la table `equipe`
--
ALTER TABLE `equipe`
  ADD PRIMARY KEY (`ID_EQUIPE`),
  ADD KEY `FK_equipe_POULE` (`id_poule`),
  ADD KEY `FK_equipe_phasefinale` (`id_phase_finale`);

--
-- Index pour la table `jouer`
--
ALTER TABLE `jouer`
  ADD PRIMARY KEY (`ID_EQUIPE`,`ID_RENCONTRE`),
  ADD KEY `FK_JOUER2` (`ID_RENCONTRE`);

--
-- Index pour la table `phase_finale`
--
ALTER TABLE `phase_finale`
  ADD PRIMARY KEY (`ID_PHASE_FINALE`),
  ADD KEY `FK_CONCERNER2` (`ID_COMPETITION`);

--
-- Index pour la table `posseder`
--
ALTER TABLE `posseder`
  ADD PRIMARY KEY (`ID_USER`,`ID_ROLE`),
  ADD KEY `FK_POSSEDER2` (`ID_ROLE`);

--
-- Index pour la table `poule`
--
ALTER TABLE `poule`
  ADD PRIMARY KEY (`ID_POULE`),
  ADD KEY `FK_CONCERNER` (`ID_COMPETITION`);

--
-- Index pour la table `pronostiquer`
--
ALTER TABLE `pronostiquer`
  ADD PRIMARY KEY (`ID_USER`,`ID_RENCONTRE`),
  ADD KEY `FK_PRONOSTIQUER2` (`ID_RENCONTRE`);

--
-- Index pour la table `rencontre`
--
ALTER TABLE `rencontre`
  ADD PRIMARY KEY (`ID_RENCONTRE`),
  ADD KEY `FK_APPARTENIR_PHASE` (`ID_PHASE_FINALE`),
  ADD KEY `FK_APPARTENIR_POULE` (`ID_POULE`);

--
-- Index pour la table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`ID_ROLE`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`ID_USER`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `competition`
--
ALTER TABLE `competition`
  MODIFY `ID_COMPETITION` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `equipe`
--
ALTER TABLE `equipe`
  MODIFY `ID_EQUIPE` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `phase_finale`
--
ALTER TABLE `phase_finale`
  MODIFY `ID_PHASE_FINALE` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `poule`
--
ALTER TABLE `poule`
  MODIFY `ID_POULE` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `rencontre`
--
ALTER TABLE `rencontre`
  MODIFY `ID_RENCONTRE` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `role`
--
ALTER TABLE `role`
  MODIFY `ID_ROLE` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `ID_USER` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
