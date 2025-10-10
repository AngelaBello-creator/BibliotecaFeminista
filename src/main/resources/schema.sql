
DROP TABLE IF EXISTS books;

CREATE TABLE books (
    id INTEGER PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255),
    isbn VARCHAR(20),
    description TEXT,
    genre VARCHAR(255)
);

INSERT INTO books (id, title, author, isbn, description, genre) VALUES
(1, 'Olympia', 'Anita Shreve', '9788408038184',
 'Olympia, a young Boston socialite, has a forbidden affair with an older doctor, becomes pregnant, is sent to a convent, and later fights to reclaim her child.',
 'Novel, Fiction, Romance'),

(2, 'The Boy Who Drew Constellations', 'Alice Kellen', '9788408234579',
 'Valentina, who dreamed of the impossible, meets Gabriel, the boy who drew constellations, and together they face love, memories, and the ideals that shape them.',
 'Novel, Romance, Drama'),

(3, 'The Cruel Prince', 'Holly Black', '9788417390617',
 'Jude, a mortal in the Faerie Court after her parents death, must confront the cruel Prince Cardan, navigate palace intrigues, and use her bloodshed skill to save her family and kingdom.',
 'Novel, Fantasy, Adventure'),

(4, 'Sapiens: A Brief History of Humankind', 'Yuval Noah Harari', '9788499924470',
 'A sweeping history of humankind, tracing our evolution from early hominids to the modern age, and exploring how biology, culture, and imagination have together shaped human societies.',
 'Non-fiction, History, Anthropology, Philosophy'),

(5, 'Mans Search for Meaning', 'Viktor E. Frankl', '9788420672093',
 'Viktor Frankl recounts his experiences in Nazi concentration camps and how they inspired logotherapy, a psychological approach emphasizing the pursuit of meaning as humanity’s central drive.',
 'Non-fiction, Psychology, Philosophy'),

(6, 'Women Who Run With the Wolves', 'Clarissa Pinkola Estés', '9788425331224',
 'A poetic and psychological look at myths and fairy tales revealing women’s instinctive and creative power, exploring resilience, identity, and the essence of female empowerment.',
 'Non-fiction, Psychology, Feminism, Mythology'),

(7, 'The Summer of the Ubume', 'Natsuhiko Kyogoku', '9784796640124',
 'A mysterious case arises when a woman remains pregnant for 20 months. Kyogokudo, an eccentric bookseller-exorcist, uncovers the truth through folklore, mystery, and human fear.',
 'Mystery, Supernatural fiction'),

(8, 'Ghost Tower', 'Edogawa Rampo', '9784000254199',
 'In Taishō-era Nagasaki, Mitsuo Kitagawa meets the mysterious Akiko Nozue at a haunted clock tower, where hidden secrets, strange figures, and supernatural whispers shape their fate.',
 'Mystery, Gothic fiction'),

(9, 'The jolly postman', 'Janet Ahlberg, Allan Ahlberg', '9784579402758',
 'A cheerful postman delivers letters to fairy-tale characters like Cinderella and the Big Bad Wolf, blending storytelling and playful mail in a charming, interactive adventure for children.',
 'Picture book, Fantasy'),

(10, 'She Myself and I', 'Emma Young', '9781847159427',
 'After Rosa becomes quadriplegic, she depends on her brother. When a Boston doctor selects her for an experimental brain transplant, their family leaves London seeking a life-changing miracle.',
 'Science fiction'),

(11, 'Of Love and Shadows', 'Isabel Allende', '9788497592543',
 'This is the story of a woman and a man who loved each other completely, thus saving themselves from a vulgar existence.',
 'Novel, Romance'),

(12, 'How to Make Good Things Happen', 'Marian Rojas Estapé', '9781682686478',
 'For those in pursuit of a better life, psychiatrist Marian Rojas Estapé presents the essential guide to neuroscience-driven mindfulness.',
 'Psychology, Self-help');
