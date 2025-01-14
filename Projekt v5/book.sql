-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sty 11, 2025 at 11:32 PM
-- Wersja serwera: 10.4.32-MariaDB
-- Wersja PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `book`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `book`
--

CREATE TABLE `book` (
  `id` bigint(20) NOT NULL,
  `author` varchar(255) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `rating` double NOT NULL,
  `title` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`id`, `author`, `category`, `description`, `price`, `rating`, `title`) VALUES
(1, 'J.R.R. Tolkien', 'Fantasy', 'Epicka opowieść o podróży Froda Bagginsa, aby zniszczyć Pierścień Władzy.', 49.99, 4.9, 'Władca Pierścieni'),
(3, 'Frank Herbert', 'Sci-Fi', 'Klasyczna powieść science fiction o walce o kontrolę nad pustynną planetą Arrakis.', 59.99, 4.7, 'Dune'),
(4, 'Stephenie Meyer', 'Romans', 'Historia miłosna między ludzką dziewczyną a wampirem.', 29.99, 3.9, 'Zmierzch'),
(6, 'J.K. Rowling', 'Fantasy', 'Pierwsza część przygód młodego czarodzieja Harry\'e...', 39.99, 4.8, 'Harry Potter i Kamień Filozoficzny'),
(7, 'Frank Herbert', 'Sci-Fi', 'Klasyczna powieść science fiction o walce o kontro...', 59.99, 4.7, 'Dune'),
(8, 'Stephenie Meyer', 'Romans', 'Historia miłosna między ludzką dziewczyną a wampir...', 29.99, 3.9, 'Zmierzch'),
(9, 'George R.R. Martin', 'Fantasy', 'Pierwszy tom sagi „Pieśni Lodu i Ognia”, opowiadającej o brutalnej walce o władzę w królestwie Westeros.', 54.99, 4.9, 'Gra o Tron'),
(10, 'Andrzej Sapkowski', 'Fantasy', 'Pierwsza część przygód Geralta z Rivii, wiedźmina, który przemierza świat, walcząc z potworami.', 44.99, 4.8, 'Wiedźmin: Ostatnie Życzenie'),
(11, 'Isaac Asimov', 'Sci-Fi', 'Klasyczna powieść science fiction o rozwoju robotów i ich relacjach z ludźmi.', 49.99, 4.7, 'Ja, Robot'),
(12, 'Philip K. Dick', 'Sci-Fi', 'Powieść o alternatywnej rzeczywistości, w której naziści wygrali II wojnę światową.', 39.99, 4.6, 'Człowiek z Wysokiego Zamku'),
(13, 'Jane Austen', 'Romans', 'Klasyczna powieść o miłości i małżeństwie w Anglii na początku XIX wieku.', 29.99, 4.5, 'Duma i Uprzedzenie'),
(14, 'Nicholas Sparks', 'Romans', 'Historia miłosna między dwojgiem młodych ludzi, których dzieli pochodzenie społeczne.', 34.99, 4.4, 'Pamiętnik'),
(15, 'Dan Brown', 'Thriller', 'Robert Langdon rozwiązuje zagadkę związaną z tajemniczym symbolem i tajnymi stowarzyszeniami.', 49.99, 4.3, 'Kod Leonarda da Vinci'),
(16, 'Gillian Flynn', 'Thriller', 'Mrożąca krew w żyłach historia małżeństwa, w którym nic nie jest takie, jak się wydaje.', 39.99, 4.2, 'Zaginiona Dziewczyna'),
(17, 'Brandon Sanderson', 'Fantasy', 'Epicka opowieść o świecie, w którym magia jest związana z metalami, a bohaterowie walczą o przetrwanie.', 59.99, 4.9, 'Mistborn: Ostateczne Imperium'),
(18, 'Patrick Rothfuss', 'Fantasy', 'Historia Kvothe\'a, genialnego muzyka i maga, który opowiada o swoim burzliwym życiu.', 54.99, 4.8, 'Imię Wiatru'),
(19, 'Margaret Atwood', 'Sci-Fi', 'Dystopijna wizja przyszłości, w której kobiety są podporządkowane reżimowi totalitarnemu.', 44.99, 4.7, 'Opowieść Podręcznej'),
(20, 'Harper Lee', 'Literatura piękna', 'Poruszająca historia o rasizmie i niesprawiedliwości w małym miasteczku na południu USA.', 34.99, 5, 'Zabić drozda'),
(21, 'Fiodor Dostojewski', 'Klasyka', 'Głęboka analiza ludzkiej psychiki w kontekście zbrodni i kary.', 29.99, 5, 'Zbrodnia i kara'),
(22, 'E.L. James', 'Romans', 'Kontrowersyjna historia miłosna między młodą studentką a bogatym biznesmenem.', 24.99, 2.5, 'Pięćdziesiąt twarzy Greya'),
(23, 'Danielle Steel', 'Romans', 'Typowa powieść obyczajowa o miłości i trudnych wyborach.', 19.99, 2.8, 'Miłość w czasach wojny'),
(24, 'James Patterson', 'Thriller', 'Przewidywalny thriller o seryjnym mordercy i śledztwie, które prowadzi do zaskakujących wniosków.', 29.99, 3, 'Zabójczy instynkt'),
(25, 'Nicholas Sparks', 'Romans', 'Historia miłosna, która nie wnosi nic nowego do gatunku.', 22.99, 2.7, 'Najdłuższa podróż'),
(26, 'Stephenie Meyer', 'Fantasy', 'Kontynuacja „Zmierzchu”, która nie dorównuje poziomem pierwszej części.', 27.99, 2.9, 'Księżyc w nowiu'),
(27, 'Paulo Coelho', 'Literatura piękna', 'Książka, która wielu czytelników uważa za przereklamowaną.', 21.99, 2.6, 'Jedenaście minut'),
(28, 'Dan Brown', 'Thriller', 'Kolejna powieść o Robertcie Langdonie, która nie zaskakuje.', 34.99, 3.1, 'Inferno'),
(29, 'Suzanne Collins', 'Fantasy', 'Kontynuacja „Igrzysk śmierci”, która nie dorównuje poziomem pierwszej części.', 31.99, 2.8, 'W pierścieniu ognia'),
(30, 'Veronica Roth', 'Sci-Fi', 'Książka, która nie spełniła oczekiwań fanów dystopii.', 26.99, 2.5, 'Zbuntowana'),
(31, 'John Green', 'Romans', 'Historia miłosna, która wielu czytelników uznała za zbyt melodramatyczną.', 23.99, 2.9, 'Szukając Alaski'),
(50, 'Autor X', 'Thriller', 'Przewidywalna historia, która nie zaskakuje.', 14.99, 1, 'Nudny thriller'),
(51, 'Autor Y', 'Romans', 'Banalna historia miłosna bez głębi.', 12.99, 1, 'Beznadziejna miłość'),
(52, 'Autor Z', 'Fantasy', 'Słabo napisana powieść fantasy bez oryginalności.', 17.99, 1, 'Zapomniana kraina'),
(53, 'Autor W', 'Sci-Fi', 'Nudna i chaotyczna powieść science fiction.', 19.99, 1, 'Kosmiczna porażka'),
(54, 'Antoine de Saint-Exupéry', 'Literatura piękna', 'Piękna opowieść filozoficzna dla dzieci i dorosłych.', 19.99, 5, 'Mały Książę'),
(55, 'Leo Tolstoy', 'Klasyka', 'Epicka powieść o miłości, wojnie i społeczeństwie w czasach napoleońskich.', 39.99, 5, 'Wojna i pokój'),
(56, 'Gabriel García Márquez', 'Literatura piękna', 'Magiczna opowieść o miłości, rodzinie i czasie.', 29.99, 5, 'Sto lat samotności');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `cart`
--

CREATE TABLE `cart` (
  `id` bigint(20) NOT NULL,
  `quantity` int(11) NOT NULL,
  `book_id` bigint(20) DEFAULT NULL,
  `book_price` double NOT NULL,
  `book_title` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `challenge`
--

CREATE TABLE `challenge` (
  `id` bigint(20) NOT NULL,
  `books_read` int(11) NOT NULL,
  `goal` int(11) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `created_at` datetime(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `review`
--

CREATE TABLE `review` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `rating` int(11) NOT NULL,
  `review_text` varchar(255) DEFAULT NULL,
  `book_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK5n0sq8ulj6ykdnrh4dnk0vfmw` (`book_id`);

--
-- Indeksy dla tabeli `challenge`
--
ALTER TABLE `challenge`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `review`
--
ALTER TABLE `review`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK70yrt09r4r54tcgkrwbeqenbs` (`book_id`);

--
-- Indeksy dla tabeli `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `book`
--
ALTER TABLE `book`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=57;

--
-- AUTO_INCREMENT for table `cart`
--
ALTER TABLE `cart`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT for table `challenge`
--
ALTER TABLE `challenge`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `review`
--
ALTER TABLE `review`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cart`
--
ALTER TABLE `cart`
  ADD CONSTRAINT `FK5n0sq8ulj6ykdnrh4dnk0vfmw` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`);

--
-- Constraints for table `review`
--
ALTER TABLE `review`
  ADD CONSTRAINT `FK70yrt09r4r54tcgkrwbeqenbs` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
