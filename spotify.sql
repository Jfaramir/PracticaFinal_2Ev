-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 13-02-2019 a las 19:33:16
-- Versión del servidor: 10.1.26-MariaDB
-- Versión de PHP: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `spotify`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `album`
--

CREATE TABLE `album` (
  `Id` int(11) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `numero_canciones` int(11) NOT NULL,
  `Anno_Lanzamiento` date NOT NULL,
  `Id_Artista` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `album`
--

INSERT INTO `album` (`Id`, `Nombre`, `numero_canciones`, `Anno_Lanzamiento`, `Id_Artista`) VALUES
(1, 'Fight Back: The Collection', 5, '2018-01-01', 1),
(2, 'Evolver', 5, '2018-01-01', 2),
(3, 'Different World', 5, '2018-01-01', 3),
(4, 'Marines a pleno sol', 4, '2008-01-01', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `artista`
--

CREATE TABLE `artista` (
  `Id` int(11) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `Estilo` varchar(30) NOT NULL,
  `Anno_inicio_artistico` date NOT NULL,
  `Idioma` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `artista`
--

INSERT INTO `artista` (`Id`, `Nombre`, `Estilo`, `Anno_inicio_artistico`, `Idioma`) VALUES
(1, 'Neffex', 'Trap/Rock', '2010-01-01', 'Ingles'),
(2, 'Smash Into Pieces', 'Rock', '2013-01-01', 'Ingles'),
(3, 'Alan Walker', 'Electronica', '2015-01-01', 'Ingles'),
(4, 'Los Nikis', 'Pop/Rock', '1987-01-01', 'Español');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cancion`
--

CREATE TABLE `cancion` (
  `Id` int(11) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `duracion_cancion` varchar(30) NOT NULL,
  `Fecha_creacion` date NOT NULL,
  `Album_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cancion`
--

INSERT INTO `cancion` (`Id`, `Nombre`, `duracion_cancion`, `Fecha_creacion`, `Album_id`) VALUES
(1, 'Fight Back', '3:20', '2017-01-01', 1),
(2, 'Soldier', '3:36', '2017-01-01', 1),
(3, 'Unstoppable', '3:24', '2017-01-01', 1),
(4, 'Watch Me', '4:06', '2017-01-01', 1),
(5, 'Spartan', '2:34', '2017-01-01', 1),
(6, 'The game(Womanizer)', '3:05', '2018-08-27', 2),
(7, 'Hall of Fame', '3:35', '2018-08-27', 2),
(8, 'Breaking Out', '3:14', '2018-08-27', 2),
(9, 'Like This!', '3:15', '2018-08-27', 2),
(10, 'Paradise', '3:08', '2018-08-27', 2),
(11, 'Different World', '3:23', '2018-12-13', 3),
(12, 'Darkside', '3:32', '2018-12-13', 3),
(13, 'Faded', '3:33', '2018-12-13', 3),
(14, 'Alone', '2:24', '2018-12-13', 3),
(15, 'Sing me to Sleep', '3:10', '2018-12-13', 3),
(16, 'El imperio contraataca', '3:12', '2008-12-11', 4),
(17, 'Ave Cesar', '2:59', '2008-12-11', 4),
(18, 'Olaf el vikingo', '2:36', '2008-12-11', 4),
(19, 'La cancion de la suciedad', '3:45', '2008-12-11', 4);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `album`
--
ALTER TABLE `album`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `Id_Artista` (`Id_Artista`);

--
-- Indices de la tabla `artista`
--
ALTER TABLE `artista`
  ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `cancion`
--
ALTER TABLE `cancion`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `Album_id` (`Album_id`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `album`
--
ALTER TABLE `album`
  ADD CONSTRAINT `album_ibfk_1` FOREIGN KEY (`Id_Artista`) REFERENCES `artista` (`Id`);

--
-- Filtros para la tabla `cancion`
--
ALTER TABLE `cancion`
  ADD CONSTRAINT `cancion_ibfk_1` FOREIGN KEY (`Album_id`) REFERENCES `album` (`Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
