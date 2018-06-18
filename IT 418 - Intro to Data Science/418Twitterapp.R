require(twitteR)
require(RCurl)
require(tm)
require(wordcloud)

# Create a developer account at apps.twitter.com to create an app and to get the following keys

consumer_key  <- 'WmsIjI8N0h3lHodX9mwf6RIcn'
consumer_secret  <- 'em17nloIAG9ME0BySaxdBwBxNauhWdOD5lntSTU8xuwgvAfB1o'
access_token  <- '960973273629708295-2EvtRhTMhh8rDHXGoow185BTcZ93EES'
access_secret  <- 'qdtSvXt16YwtK8j32pTa7JWPoVT5uTr0plueBpCAWikLQ'

setup_twitter_oauth(consumer_key, consumer_secret, access_token, access_secret)

# Get the tweets from Twitter 
bd_tweets = searchTwitter("big data", n=500, lang="en")
bd_text = sapply(bd_tweets, function(x) x$getText())

# Create a corpus
bd_corpus = Corpus(VectorSource(bd_text))

# Inspect the corpus
inspect(bd_corpus[1])

# Clean the corpus by removing punctuation, numbers, and white spaces
bd_clean  <- tm_map(bd_corpus, removePunctuation)
bd_clean  <- tm_map(bd_clean, removeNumbers)
bd_clean  <- tm_map(bd_clean, stripWhitespace)

# Create Word Cloud from clean data
wordcloud(bd_clean)

# Modify your Word Cloud
wordcloud(bd_clean, random.order = F, max.words = 50, scale = c(3, 0.5))

wordcloud(bd_clean, random.order = F, max.words = 50, scale = c(3, 0.5), color = rainbow(50))

#############################################CLASS 2###########################################################

# Get the tweets from Twitter 
bd_tweets = searchTwitter("rbukralia", n=500, lang="en", geocode='44.986656,-93.258133, 80mi')
bd_text = sapply(bd_tweets, function(x) x$getText())

# Create a corpus
bd_corpus = Corpus(VectorSource(bd_text))

# Inspect the corpus
inspect(bd_corpus[1])

# Clean the corpus by removing punctuation, numbers, and white spaces
bd_clean  <- tm_map(bd_corpus, removePunctuation)
bd_clean <- tm_map(bd_clean, tolower)
bd_clean  <- tm_map(bd_clean, removeNumbers)
# Remove stopwords and specific words 
bd_clean <- tm_map(bd_clean, removeWords, stopwords("english"))
bd_clean  <- tm_map(bd_clean, stripWhitespace)
bd_clean <- tm_map(bd_clean, removeWords, c("rbukralia", "bukralia"))

# Optional: Add this code if you run into errors on Macs
bd_clean  <- iconv(bd_clean,to="utf-8-mac")

# Create Word Cloud from clean data
wordcloud(bd_clean)

# Modify your Word Cloud
wordcloud(bd_clean, random.order = F, max.words = 50, scale = c(3, 0.5))

wordcloud(bd_clean, random.order = F, max.words = 50, scale = c(3, 0.5), color = rainbow(50))

###########################################CLASS 2 PART 2 #############################################

bd_tweets = searchTwitter("Mankato", n=500, lang="en", since="2018-01-01")
bd_text = sapply(bd_tweets, function(x) x$getText())

# Create a corpus
bd_corpus = Corpus(VectorSource(bd_text))

# Inspect the corpus
inspect(bd_corpus[1])

# Clean the corpus by removing punctuation, numbers, and white spaces
bd_clean  <- tm_map(bd_corpus, removePunctuation)
bd_clean <- tm_map(bd_clean, tolower)
bd_clean  <- tm_map(bd_clean, removeNumbers)
# Remove stopwords and specific words 
bd_clean <- tm_map(bd_clean, removeWords, stopwords("english"))
bd_clean  <- tm_map(bd_clean, stripWhitespace)
bd_clean <- tm_map(bd_clean, removeWords, c("mankato", "minnesota"))

# Optional: Add this code if you run into errors on Macs
bd_clean  <- iconv(bd_clean,to="utf-8-mac")

# Create Word Cloud from clean data
wordcloud(bd_clean)

# Modify your Word Cloud
wordcloud(bd_clean, random.order = F, max.words = 50, scale = c(3, 0.5))

wordcloud(bd_clean, random.order = F, max.words = 50, scale = c(3, 0.5), color = rainbow(50))
