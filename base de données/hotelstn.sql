-- phpMyAdmin SQL Dump
-- version 4.0.10.18
-- https://www.phpmyadmin.net
--
-- Host: localhost:3306
-- Generation Time: Apr 07, 2018 at 10:14 AM
-- Server version: 5.6.39-cll-lve
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `hotelstn`
--

-- --------------------------------------------------------

--
-- Table structure for table `hotels`
--

CREATE TABLE IF NOT EXISTS `hotels` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `image` varchar(100) NOT NULL,
  `etoiles` int(11) NOT NULL,
  `adresse` varchar(100) NOT NULL,
  `gouvernorat` varchar(100) NOT NULL,
  `num` int(100) NOT NULL,
  `site` varchar(100) NOT NULL,
  `maps_x` double NOT NULL,
  `maps_y` double NOT NULL,
  `image2` varchar(100) NOT NULL,
  `image3` varchar(100) NOT NULL,
  `wifi` tinyint(1) DEFAULT NULL,
  `air` tinyint(1) DEFAULT NULL,
  `bar` tinyint(1) DEFAULT NULL,
  `pool` tinyint(1) DEFAULT NULL,
  `breakfast` tinyint(1) DEFAULT NULL,
  `parking` tinyint(1) DEFAULT NULL,
  `restaurent` tinyint(1) DEFAULT NULL,
  `child` tinyint(1) DEFAULT NULL,
  `spa` tinyint(1) DEFAULT NULL,
  `pets` tinyint(1) DEFAULT NULL,
  `roomservice` tinyint(1) DEFAULT NULL,
  `laundry` tinyint(1) DEFAULT NULL,
  `gym` tinyint(1) DEFAULT NULL,
  `beach` tinyint(1) DEFAULT NULL,
  `golf` tinyint(1) DEFAULT NULL,
  `smoking` tinyint(1) DEFAULT NULL,
  `wheel` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=20 ;

--
-- Dumping data for table `hotels`
--

INSERT INTO `hotels` (`id`, `name`, `description`, `image`, `etoiles`, `adresse`, `gouvernorat`, `num`, `site`, `maps_x`, `maps_y`, `image2`, `image3`, `wifi`, `air`, `bar`, `pool`, `breakfast`, `parking`, `restaurent`, `child`, `spa`, `pets`, `roomservice`, `laundry`, `gym`, `beach`, `golf`, `smoking`, `wheel`) VALUES
(1, 'Movenpick Resort & Marine Spa', 'On a sandy Sousse beach, this upscale resort is 17 km from Monastir Habib Bourguiba Airport and 3 km from the bustling Sousse Medina.\n\nFeaturing pool or garden views, the elegant, airy rooms offer free Wi-Fi, flat-screen TVs, safes and minibars, as well as tea and coffeemakers. Upgraded rooms offer balconies with views of the sea. Suites add living rooms, some have terraces. Room service is available.\n\nFreebies include breakfast, parking and airport shuttles. There are 5 upmarket restaurants, 1 of which serves French cuisine, and 6 bars. There''s also a gym, a lagoon-style outdoor pool, a kids'' club and a luxe spa with a saltwater pool.', 'https://s-ec.bstatic.com/images/hotel/max1024x768/120/120700636.jpg', 5, 'Boulevard du 14 Janvier, B.P 114, Sousse 4039', 'Sousse', 73202000, 'https://www.movenpick.com', 35.8423521, 10.6270163, 'https://www.newlooktravel.tn/photo/15125568451-MIR_Moevenpick_Sousse_021.jpg', 'https://media-cdn.tripadvisor.com/media/photo-s/01/8e/8e/29/moevenpick-sousse-face.jpg', 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1),
(2, 'La Badira', 'On a sandy Sousse beach, this upscale resort is 17 km from Monastir Habib Bourguiba Airport and 3 km from the bustling Sousse Medina.\n\nFeaturing pool or garden views, the elegant, airy rooms offer free Wi-Fi, flat-screen TVs, safes and minibars, as well as tea and coffeemakers. Upgraded rooms offer balconies with views of the sea. Suites add living rooms, some have terraces. Room service is available.\n\nFreebies include breakfast, parking and airport shuttles. There are 5 upmarket restaurants, 1 of which serves French cuisine, and 6 bars. There''s also a gym, a lagoon-style outdoor pool, a kids'' club and a luxe spa with a saltwater pool.', 'https://s-ec.bstatic.com/images/hotel/max1024x768/421/42192660.jpg', 4, 'Villa De Charme Hammamet/Tunisie, Hammamet 8050', 'Hammamet', 2147483647, 'https://www.labadira.com', 36.4036193, 10.6491506, 'https://1.bp.blogspot.com/-RRo2XwHyJaY/Vreo7XXRM3I/AAAAAAABQOQ/XDqKgoeSNnI/s1600/La%2BBadira%2B-%2BT', 'https://aff.bstatic.com/images/hotel/840x460/758/75881056.jpg', 0, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, NULL, NULL, NULL),
(3, 'Hotel Marhaba Beach', 'In a sprawling whitewashed building on a Mediterranean Sea beach, this relaxed resort is 2 km from Casino Europe, 4 km from the Sousse Archaeological Museum and 8 km from Port El Kantaoui.\r\n\r\nThe colorful rooms and suites offer free Wi-Fi and flat-screen TVs, along with minibars and balconies; some have sea views. Room service is available.\r\n\r\nBreakfast is complimentary. Other amenities include an international buffet restaurant and a beachfront snack bar, plus a heated indoor pool, and 2 outdoor pools (1 for kids) with a poolside bar. There&rsquo;s also a nightclub, a playground and a fitness center, as well as sports courts, a sauna and a lobby lounge.', 'https://s-ec.bstatic.com/images/hotel/max1280x900/107/107123433.jpg', 4, 'Boulevard 14 janvier, Sousse 4039', 'Sousse', 73240112, 'https://www.marhabahotels.tn', 35.8481507, 10.6227898, 'https://s-ec.bstatic.com/images/hotel/max1024x768/107/107123423.jpg', 'https://s-ec.bstatic.com/images/hotel/max1280x900/107/107123433.jpg', 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, NULL, 1, NULL, NULL),
(4, 'Delphin Ribat Hotel', 'Cet h&ocirc;tel en bord de plage propose des soins de bien-&ecirc;tre Situation B&eacute;n&eacute;ficiant d''un bel emplacement dans la zone de Monastir, cet h&ocirc;tel de front de mer se trouve dans le centre-ville, &agrave; moins de 10 minutes de marche de Gallery Espressioni et Plage de Monastir. Ribat de Monastir et Musol&eacute;e de Bourguiba se trouvent &eacute;galement &agrave; moins de 2 km de distance. Services et &eacute;quipements L''&eacute;tablissement vous propose une piscine couverte et vous invite &agrave; passer vos journ&eacute;es &agrave; la plage, o&ugrave; vous pourrez pratiquer le volley. Chambres L''ensemble des 180 chambres mettent &agrave; votre disposition l''acc&egrave;s Wi-Fi &agrave; Internet gratuit, des balcons et des t&eacute;l&eacute;visions. Les autres prestations qui vous sont disponibles comprennent un s&egrave;che-cheveux, des coffre-forts et des t&eacute;l&eacute;phones.', 'https://t-ec.bstatic.com/images/hotel/max1024x768/422/42211827.jpg', 3, 'Avenue Habib Bourguiba, Monastir 5000', 'Monastir', 73466750, 'https://via.eviivo.com', 35.772936, 10.836443, 'https://s-ec.bstatic.com/images/hotel/max1024x768/422/42211933.jpg', 'https://fwk.e-receptif.com:447/cr.fwk/images/hotels/Section-1595-20120307-112832.jpg', 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, NULL, NULL, 1, NULL),
(5, 'Hotel Dar Hayat', 'This homey beachfront hotel is 1 km from both Carthageland amusement park and the Kasbah, a 13th-century fort. Pupput, a Roman-era archaeological site, is 6 km away.\n\nUnderstated rooms blend minimalist and Moorish-style decor. All provide balconies or terraces, plus minifridges, flat-screens and free Wi-Fi. Upgraded quarters offer views of the Gulf of Hammamet, while suites add garden views and separate sitting areas. Room service is available.\n\nComplimentary continental breakfast is served in a relaxed eatery that has open-air seating. A simple rooftop terrace offers a bar and gulf views. There''s also an outdoor pool, a gym and a sauna.', 'https://media.expedia.com/hotels/3000000/2780000/2775400/2775394/2775394_3_b.jpg', 1, 'Rue akaba Hasmmset BP 78, Hammamet 8050', 'Hammamet', 1, 'https://google.com', 12, 26, 'https://media-cdn.tripadvisor.com/media/photo-s/02/aa/9e/bd/pool-view.jpg', 'https://media.expedia.com/hotels/3000000/2780000/2775400/2775394/2775394_11_b.jpg', 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, NULL, NULL, NULL, 1),
(6, 'Tunisia Palace', 'Situ&eacute; dans le quartier central de Bab Bhar, cet h&ocirc;tel raffin&eacute; de style Belle &eacute;poque se trouve &agrave; 6 minutes &agrave; pied de la station de m&eacute;tro Habib Thameur et &agrave; 5 km du mus&eacute;e national du Bardo. \r\n\r\nLes chambres &agrave; la d&eacute;coration chaleureuse sont &eacute;quip&eacute;es d''une t&eacute;l&eacute;vision &agrave; &eacute;cran plat et d''un acc&egrave;s Internet. Une suite &eacute;l&eacute;gante avec boiseries d&eacute;coratives comprend &eacute;galement une salle de s&eacute;jour s&eacute;par&eacute;e.\r\n\r\nL''&eacute;tablissement comprend un restaurant &eacute;l&eacute;gant, dont le plafond est surmont&eacute; d''une coupole d&eacute;cor&eacute;e de vitraux. Il poss&egrave;de &eacute;galement un bar sophistiqu&eacute; avec terrasse, un spa et un centre d''affaires.', 'http://www.tunisiapalace.com/img/logo.jpg', 4, 'Tunisia Palace, 13 Ave De France, Tunis 1000', 'Tunis', 71242700, 'https://fr.hotels.com/ho276067/tunisia-palace-tunis-tunisie/?dateless=true&amp;hotelid=276067&amp;lo', 36.7993468, 10.1770329, 'http://www.lifetravel.tn/wp-content/uploads/2015/05/1200@Tunisia-Palace.2.jpg', 'https://t-ec.bstatic.com/images/hotel/max1024x768/183/18372083.jpg', 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, NULL, NULL, NULL, NULL),
(7, 'Hotel Africa', 'Situ&eacute; dans un gratte-ciel du centre-ville, cet h&ocirc;tel se trouve &agrave; 1 km de la mosqu&eacute;e Zitouna et &agrave; 5 km du mus&eacute;e national du Bardo. \r\n\r\nLes chambres traditionnelles et sobrement meubl&eacute;es sont &eacute;quip&eacute;es de la TV par satellite, d''un acc&egrave;s Wi-Fi gratuit, d''un coffre-fort et d''un minibar. Les suites incluent en sus un espace de vie, et certaines offrent une vue panoramique sur la ville.\r\n\r\nLes 3 restaurants de l''&eacute;tablissement proposent des buffets, et des d&icirc;ners raffin&eacute;s et internationaux. L''h&ocirc;tel comprend &eacute;galement un chaleureux caf&eacute; et un bar &agrave; la r&eacute;ception.', 'http://www.elmouradi.com/cr27.fwk/images/hotels/Hotel-59-20160303-041637.jpg', 5, '50 Avenue Habib Bourguiba, Tunis 1001', 'Tunis', 71347477, 'https://www.booking.com/searchresults.fr.html?aid=311089;label=africa-tunis-FGdmbrCl0TYnf9iFcoaiVgS2', 36.7995327, 10.1832238, 'http://www.elmouradi.com/cr27.fwk/images/hotels/Hotel-59-20141202-083653.jpg', 'http://www.elmouradi.com/cr27.fwk/images/hotels/Hotel-61-20160303-042300.jpg', 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, NULL, 1, 1, NULL),
(8, 'Golden Tulip El Mechtel', 'Cet h&ocirc;tel raffin&eacute; qui borde le parc du Belv&eacute;d&egrave;re se trouve &agrave; 4 minutes &agrave; pied de la station de m&eacute;tro Bab El Khadra, &agrave; 2 km de la mosqu&eacute;e historique Zitouna et &agrave; 4 km du mus&eacute;e national du Bardo.\r\n\r\nLes chambres de style d&eacute;contract&eacute; proposent le Wi-Fi gratuit, un &eacute;cran plat et un coffre-fort. Certaines offrent une vue sur le parc et/ou sur la ville. Les chambres de cat&eacute;gorie sup&eacute;rieure affichent une d&eacute;coration moderne et comprennent un coin salon. Les suites poss&egrave;dent une salle de s&eacute;jour, et celles de cat&eacute;gorie sup&eacute;rieure comptent 2 chambres.\r\n\r\nL''h&ocirc;tel compte 3 restaurants ; l''un sert une cuisine italienne et un autre des sp&eacute;cialit&eacute;s libanaises dans une salle &agrave; manger &eacute;l&eacute;gante orn&eacute;e d''un plafond &agrave; caissons. L''&eacute;tablissement dispose &eacute;galement d''un pub, d''un salon, d''une piscine', 'https://s-ec.bstatic.com/images/hotel/max1280x900/126/126303721.jpg', 4, 'Avenue Ouled Hafouz, Tunis 1005', 'Tunis', 71783200, 'https://www.trivago.fr/?geo_distance_item=134204&amp;sem_keyword=&amp;sem_creativeid=83873940420&amp', 36.8135896, 10.1739551, 'https://t-ec.bstatic.com/images/hotel/max1024x768/126/126579643.jpg', 'http://www.eurekaesthetique.com/img/hotel%20Tunisie.png', 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, NULL, NULL, NULL),
(9, 'Marhaba Royal Salem', 'Kindness to he horrible reserved ye. Effect twenty indeed beyond for not had county. The use him without greatly can private. Increasing it unpleasant no of contrasted no continuing. Nothing colonel my no removed in weather. It dissimilar in up devonshire inhabiting. \r\n\r\nBehind sooner dining so window excuse he summer. Breakfast met certainty and fulfilled propriety led. Waited get either are wooded little her. Contrasted unreserved as mr particular collecting it everything as indulgence. Seems ask meant merry could put. Age old begin had boy noisy table front whole given.', 'https://media-cdn.tripadvisor.com/media/photo-s/02/2f/92/b7/marhaba-royal-salem.jpg', 4, 'Marhaba Royal Salem, Boulevard 7 Novembre, Sousse 4039', 'Sousse', 73271588, 'https://www.booking.com/searchresults.fr.html?aid=301664;label=salem-de-bAsSML7qGaZ9BPSXvUp06wS26021', 35.8601395, 10.6176639, 'https://image.resabooking.com/images/hotel/marhaba_royal_salem_4.jpg', 'https://a1.r9cdn.net/rimg/himg/25/98/e2/ean-237460-1214406_23_b-image.jpg?width=500&amp;height=350&a', 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, NULL, NULL, 1, NULL),
(10, 'Jalta Hotel', 'Surplombant la baie de Bizerte, cet h&ocirc;tel de style d&eacute;contract&eacute; se trouve &agrave; 2 km du parc d''attractions Sidi Salem et &agrave; 3 km du stade Ahmed Bsiri. \r\n\r\nLes chambres discr&egrave;tes disposent de carrelage et d''une t&eacute;l&eacute;vision (suppl&eacute;ment). Certaines sont dot&eacute;es d''un balcon. Les suites comprennent un coin repas et une salle de s&eacute;jour s&eacute;par&eacute;e avec un transat en alc&ocirc;ve.\r\n\r\nL''&eacute;tablissement propose un restaurant &eacute;l&eacute;gant, un caf&eacute; bar, un jardin int&eacute;rieur, ainsi qu''une piscine et une pataugeoire. Il dispose &eacute;galement d''un amphith&eacute;&acirc;tre, de 2 courts de tennis et d''une terrasse surplombant une plage priv&eacute;e dot&eacute;e d''un snack-bar. Des v&eacute;los, des 4x4 et du mat&eacute;riel de sports nautiques sont disponibles &agrave; la location. Des balades &agrave; cheval peuvent &ecirc;tre organis&eacute;es.', 'https://media-cdn.tripadvisor.com/media/photo-s/03/f4/1a/3b/hotel-jalta.jpg', 2, 'Route De La Corniche, Bizerte 7000', 'Bizerte', 72439949, 'https://www.tripadvisor.fr/SmartDeals-g480249-Bizerte_Bizerte_Governorate-Hotel-Deals.html', 37.2997674, 9.8702287, 'https://edge.media.datahc.com/HI286773538.jpg', 'https://t-ec.bstatic.com/images/hotel/max1280x900/266/26645816.jpg', 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, NULL, NULL, NULL),
(19, 'Hotel Ayachi', 'ehrzherhkerphoerkherherh', 'https://s-ec.bstatic.com/images/hotel/max1280x900/681/68184730.jpg', 1, 'eeeeeeeee', 'Sousse', 1231564646, 'rrrr', 15, 15, 'https://s-ec.bstatic.com/images/hotel/max1280x900/681/68184730.jpg', 'https://s-ec.bstatic.com/images/hotel/max1280x900/681/68184730.jpg', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `reviews`
--

CREATE TABLE IF NOT EXISTS `reviews` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idhotel` int(11) NOT NULL,
  `user` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `text` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `date` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `stars` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=16 ;

--
-- Dumping data for table `reviews`
--

INSERT INTO `reviews` (`id`, `idhotel`, `user`, `text`, `date`, `stars`) VALUES
(1, 1, 'Achraf', 'Cibo postulant intellegebat nec ne. Iudico accommodare pri eu, ex mea stet fierent salutatus, ex ius idque elitr deserunt.\r\n', 'Tue Feb 25 13:40:12 GMT+01:00 2018', 4),
(2, 1, 'Oussama', 'Cibo postulant intellegebat', 'Tue Mar 13 13:40:12 GMT+01:00 2018', 1),
(3, 1, 'Elyes', 'tres bon hotel je le recommende', 'Tue Mar 25 13:40:12 GMT+01:00 2018', 5),
(4, 1, 'Moez', 'hhh', 'Tue Apr 03 23:40:12 GMT+01:00 2018', 5),
(5, 1, 'Ali', 'looool', 'Wed Apr 04 00:00:47 GMT+01:00 2018', 5),
(6, 7, 'Ali', 'hello', 'Wed Apr 04 01:44:32 GMT+01:00 2018', 5),
(7, 1, 'Mouhab', 'definitly was worthwhile', 'Wed Apr 04 01:46:51 GMT+01:00 2018', 5),
(8, 1, 'Mazen', 'the experience was very bad', 'Wed Apr 04 01:47:22 GMT+01:00 2018', 5),
(9, 1, 'Elyes', 'Super !!', 'Wed Apr 04 10:15:38 GMT+01:00 2018', 5),
(10, 2, '', '', 'Wed Apr 04 11:01:29 GMT+01:00 2018', 5),
(11, 2, 'hamma', 'mriguel ', 'Wed Apr 04 11:02:11 GMT+01:00 2018', 5),
(12, 1, 'alter', 'tted', 'Wed Apr 04 11:26:14 GMT+01:00 2018', 5),
(13, 19, 'abir', 'goid', 'Wed Apr 04 11:30:31 GMT+01:00 2018', 5),
(14, 2, 'dali', 'heylaaa', 'Wed Apr 04 11:32:07 GMT+01:00 2018', 5),
(15, 4, 'alioua', 'bhy', 'Wed Apr 04 11:45:34 GMT+01:00 2018', 5);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
