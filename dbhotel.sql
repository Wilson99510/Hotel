-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.6.7-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Volcando estructura para tabla dbhotel.cliente
CREATE TABLE IF NOT EXISTS `cliente` (
  `idpersona` int(11) NOT NULL,
  `codigo_cliente` varchar(10) NOT NULL,
  PRIMARY KEY (`idpersona`),
  UNIQUE KEY `codigo_UNIQUE` (`codigo_cliente`),
  CONSTRAINT `fk_usuario_cliente` FOREIGN KEY (`idpersona`) REFERENCES `usuario` (`idpersona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Volcando datos para la tabla dbhotel.cliente: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` (`idpersona`, `codigo_cliente`) VALUES
	(4, 'cl2510'),
	(26, 'cl5673'),
	(3, 'cl5847');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;

-- Volcando estructura para tabla dbhotel.consumo
CREATE TABLE IF NOT EXISTS `consumo` (
  `idconsumo` int(11) NOT NULL AUTO_INCREMENT,
  `idreserva` int(11) NOT NULL,
  `idproducto` int(11) NOT NULL,
  `cantidad` decimal(8,2) NOT NULL,
  `precio_venta` decimal(8,2) NOT NULL,
  `estado` varchar(10) NOT NULL,
  PRIMARY KEY (`idconsumo`),
  KEY `fk_consumo_producto_idx` (`idproducto`),
  KEY `fk_consumo_reserva_idx` (`idreserva`),
  CONSTRAINT `fk_consumo_producto` FOREIGN KEY (`idproducto`) REFERENCES `producto` (`idproducto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_consumo_reserva` FOREIGN KEY (`idreserva`) REFERENCES `reserva` (`idreserva`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;

-- Volcando datos para la tabla dbhotel.consumo: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `consumo` DISABLE KEYS */;
INSERT INTO `consumo` (`idconsumo`, `idreserva`, `idproducto`, `cantidad`, `precio_venta`, `estado`) VALUES
	(6, 3, 1, 4.00, 3.00, 'EN PROCESO'),
	(7, 5, 1, 2.00, 3.00, 'EN PROCESO'),
	(9, 6, 1, 2.00, 3.00, 'EN PROCESO'),
	(10, 6, 2, 2.00, 1.50, 'EN PROCESO'),
	(11, 8, 1, 3.00, 3.00, 'EN PROCESO'),
	(12, 8, 2, 5.00, 1.50, 'EN PROCESO');
/*!40000 ALTER TABLE `consumo` ENABLE KEYS */;

-- Volcando estructura para tabla dbhotel.empleado
CREATE TABLE IF NOT EXISTS `empleado` (
  `idpersona` int(11) NOT NULL,
  `sueldo` decimal(8,2) NOT NULL,
  `acceso_sistema` varchar(20) NOT NULL,
  `usuario` varchar(20) NOT NULL,
  `contraseña` varchar(30) NOT NULL,
  `estado_cuenta` varchar(1) NOT NULL,
  PRIMARY KEY (`idpersona`),
  UNIQUE KEY `usuario_UNIQUE` (`usuario`),
  CONSTRAINT `fk_usuario_empleado` FOREIGN KEY (`idpersona`) REFERENCES `usuario` (`idpersona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Volcando datos para la tabla dbhotel.empleado: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` (`idpersona`, `sueldo`, `acceso_sistema`, `usuario`, `contraseña`, `estado_cuenta`) VALUES
	(24, 5000.00, 'ADMINISTRADOR', 'admin', 'admin123', 'A'),
	(25, 2000.00, 'FUNCIONARIO', 'root', 'root123', 'A');
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;

-- Volcando estructura para tabla dbhotel.habitacion
CREATE TABLE IF NOT EXISTS `habitacion` (
  `idhabitacion` int(11) NOT NULL AUTO_INCREMENT,
  `numero_habitacion` varchar(5) NOT NULL,
  `piso` varchar(4) NOT NULL,
  `caracteristicas` varchar(100) DEFAULT NULL,
  `precio_diario` decimal(8,2) NOT NULL,
  `estado_habitacion` varchar(20) NOT NULL,
  `tipo_habitacion` varchar(25) NOT NULL,
  PRIMARY KEY (`idhabitacion`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

-- Volcando datos para la tabla dbhotel.habitacion: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `habitacion` DISABLE KEYS */;
INSERT INTO `habitacion` (`idhabitacion`, `numero_habitacion`, `piso`, `caracteristicas`, `precio_diario`, `estado_habitacion`, `tipo_habitacion`) VALUES
	(2, '69', '6', 'Cama Matrimonial, Internet Wifi', 54.00, 'Disponible', 'Matrimonial'),
	(3, '587', '5', 'Cama Individual, Internet Wifi\nTv por Cable', 180.00, 'Disponible', 'Individual'),
	(4, '453', '4', 'Cama Familiar de dos plazas, Internet\nTv por Cable, Bañera con Jacuzzi', 423.00, 'Disponible', 'Familiar');
/*!40000 ALTER TABLE `habitacion` ENABLE KEYS */;

-- Volcando estructura para tabla dbhotel.pago
CREATE TABLE IF NOT EXISTS `pago` (
  `idpago` int(11) NOT NULL AUTO_INCREMENT,
  `idreserva` int(11) NOT NULL,
  `tipo_comprobante` varchar(20) NOT NULL,
  `num_comprobante` varchar(20) NOT NULL,
  `igv` decimal(8,2) NOT NULL,
  `total_pago` decimal(8,2) NOT NULL,
  `fecha_emision` date NOT NULL,
  `fecha_pago` date NOT NULL,
  PRIMARY KEY (`idpago`),
  KEY `fk_pago_reserva_idx` (`idreserva`),
  CONSTRAINT `fk_pago_reserva` FOREIGN KEY (`idreserva`) REFERENCES `reserva` (`idreserva`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;

-- Volcando datos para la tabla dbhotel.pago: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `pago` DISABLE KEYS */;
INSERT INTO `pago` (`idpago`, `idreserva`, `tipo_comprobante`, `num_comprobante`, `igv`, `total_pago`, `fecha_emision`, `fecha_pago`) VALUES
	(2, 6, 'FACTURA', '001-001-0034545', 0.18, 1269.00, '2022-06-13', '2022-06-13'),
	(3, 5, 'FACTURA', '001-001-0046388', 0.18, 506.00, '2022-06-14', '2022-06-14'),
	(4, 3, 'FACTURA', '001-001-0087323', 0.18, 312.00, '2022-06-12', '2022-06-12'),
	(5, 8, 'FACTURA', '001-001-0034765', 0.18, 232.50, '2022-06-10', '2022-06-10');
/*!40000 ALTER TABLE `pago` ENABLE KEYS */;

-- Volcando estructura para tabla dbhotel.producto
CREATE TABLE IF NOT EXISTS `producto` (
  `idproducto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `descripcion` varchar(80) DEFAULT NULL,
  `uni_medida` varchar(25) NOT NULL,
  `precio_venta` decimal(8,2) NOT NULL,
  PRIMARY KEY (`idproducto`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

-- Volcando datos para la tabla dbhotel.producto: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` (`idproducto`, `nombre`, `descripcion`, `uni_medida`, `precio_venta`) VALUES
	(1, 'Gaseosa', 'Sabor Piña 2L ', 'LITROS', 3.00),
	(2, 'Llamadas Internacionales', 'Llamadas a telefonías móviles fuera\ndel territorio nacional.', 'MIN', 1.50);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;

-- Volcando estructura para tabla dbhotel.reserva
CREATE TABLE IF NOT EXISTS `reserva` (
  `idreserva` int(11) NOT NULL AUTO_INCREMENT,
  `idhabitacion` int(11) NOT NULL,
  `idcliente` int(11) NOT NULL,
  `idempleado` int(11) NOT NULL,
  `tipo_reserva` varchar(25) NOT NULL,
  `fecha_reserva` date NOT NULL,
  `fecha_entrada` date NOT NULL,
  `fecha_salida` date NOT NULL,
  `costo_reserva` decimal(8,2) NOT NULL,
  `estado` varchar(20) NOT NULL,
  PRIMARY KEY (`idreserva`),
  KEY `fk_reserva_habitacion_idx` (`idhabitacion`),
  KEY ` fk_reserva_cliente_idx` (`idcliente`),
  KEY `fk_reserva_empleado_idx` (`idempleado`),
  CONSTRAINT `fk_reserva_cliente` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`idpersona`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_reserva_empleado` FOREIGN KEY (`idempleado`) REFERENCES `empleado` (`idpersona`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_reserva_habitacion` FOREIGN KEY (`idhabitacion`) REFERENCES `habitacion` (`idhabitacion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;

-- Volcando datos para la tabla dbhotel.reserva: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
INSERT INTO `reserva` (`idreserva`, `idhabitacion`, `idcliente`, `idempleado`, `tipo_reserva`, `fecha_reserva`, `fecha_entrada`, `fecha_salida`, `costo_reserva`, `estado`) VALUES
	(3, 2, 4, 24, 'VIP', '2022-06-05', '2022-06-06', '2022-06-12', 300.00, 'PAGADA'),
	(5, 4, 3, 24, 'FAMILIAR', '2022-06-04', '2022-06-07', '2022-06-14', 500.00, 'PAGADA'),
	(6, 3, 4, 24, 'ALQUILER', '2022-06-01', '2022-06-06', '2022-06-13', 1260.00, 'PAGADA'),
	(8, 2, 26, 24, 'ALQUILER', '2022-06-04', '2022-06-06', '2022-06-10', 216.00, 'PAGADA');
/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;

-- Volcando estructura para tabla dbhotel.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `idpersona` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(15) NOT NULL,
  `apellido` varchar(15) NOT NULL,
  `tipo_documento` varchar(15) NOT NULL,
  `numero_documento` varchar(10) NOT NULL,
  `direccion` varchar(70) DEFAULT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  `correo` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idpersona`),
  UNIQUE KEY `telefono_UNIQUE` (`telefono`),
  UNIQUE KEY `email_UNIQUE` (`correo`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb3;

-- Volcando datos para la tabla dbhotel.usuario: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`idpersona`, `nombre`, `apellido`, `tipo_documento`, `numero_documento`, `direccion`, `telefono`, `correo`) VALUES
	(3, 'Laura', 'Aguirre', 'DNI', '28048475', 'Formosa', '0986743261', 'lauraa21@gmail.com'),
	(4, 'Wilson', 'Caballero', 'CI', '5987310', 'San Lorenzo', '0986342519', 'rcaballero@gmail.com'),
	(24, 'Juan', 'Esquivel', 'CI', '2145345', 'Aratiri', '0983958372', 'juan_e@gmail.com'),
	(25, 'Jorge', 'Martinez', 'CI', '4284503', 'Santa Ana', '0983172354', 'jorge@gmail.com'),
	(26, 'Juan', 'Aquino', 'CI', '3567322', 'Moras Cue', '0983536127', 'juan@gmail.com');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
