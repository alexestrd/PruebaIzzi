-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-11-2023 a las 04:27:36
-- Versión del servidor: 10.4.25-MariaDB
-- Versión de PHP: 7.4.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `izzi`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `consultas`
--

CREATE TABLE `consultas` (
  `id` bigint(20) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `ip` varchar(30) NOT NULL,
  `cp` int(11) NOT NULL,
  `ciudad` varchar(30) NOT NULL,
  `pais` varchar(30) NOT NULL,
  `estado` varchar(30) NOT NULL,
  `idioma` varchar(30) NOT NULL,
  `moneda` varchar(30) NOT NULL,
  `continente` varchar(30) NOT NULL,
  `longitud` varchar(15) NOT NULL,
  `latitud` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `consultas`
--

INSERT INTO `consultas` (`id`, `nombre`, `ip`, `cp`, `ciudad`, `pais`, `estado`, `idioma`, `moneda`, `continente`, `longitud`, `latitud`) VALUES
(2, 'Alexis', '177.247.126.150', 50210, 'Toluca', 'Mexico', 'State of Mexico', 'Spanish language', 'Mexican peso', 'North America', '-99.6321', '19.3031'),
(5, 'Alexis', '69.162.81.155', 75202, 'Dallas', 'United States of America', 'Texas', 'Spanish language', 'United States dollar', 'North America', '-96.803474', '32.78088'),
(8, 'Alexis', '162.254.206.227', 33197, 'Miami', 'United States of America', 'Florida', 'Spanish language', 'United States dollar', 'North America', '-80.1946', '25.7689'),
(9, 'Alexis', '200.7.98.19', 20146, 'Ashburn', 'United States of America', 'Virginia', 'Spanish language', 'United States dollar', 'North America', '-77.6443', '39.0814'),
(10, 'Alexis', '131.255.7.26', 1871, 'Buenos Aires', 'Argentina', 'Buenos Aires F.D.', 'Spanish language', 'Argentine peso', 'South America', '-58.3811', '-34.6142');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` bigint(20) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `apellidos` varchar(40) NOT NULL,
  `correo` varchar(30) NOT NULL,
  `contraseña` varchar(150) NOT NULL,
  `telefono` bigint(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre`, `apellidos`, `correo`, `contraseña`, `telefono`) VALUES
(1, 'Alexis', 'Estrada', 'trab.proyec.alex@gmail.com', '$argon2id$v=19$m=1024,t=1,p=1$bFd5EmfocPysX/jpbytfoQ$p/arJVrLKSPl6cPDfRUQcptwCx1OdaI4MsvMl5lJZ7A', 7291208066);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `consultas`
--
ALTER TABLE `consultas`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `consultas`
--
ALTER TABLE `consultas`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
