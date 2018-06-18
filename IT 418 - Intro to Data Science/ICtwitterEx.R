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


mn_tweets = searchTwitter("Minnesota", n=500, lang='en')
mn_text = sapply(mn_tweets, function(x) x$getText())

mn_corpus = Corpus(VectorSource(mn_text))

inspect(mn_corpus[1])

mn_clean  <- tm_map(mn_corpus, removePunctuation)
mn_clean  <- tm_map(mn_clean, removeNumbers)
mn_clean  <- tm_map(mn_clean, stripWhitespace)
mn_clean <- tm_map(mn_clean, tolower)
mn_clean <- tm_map(mn_clean, removeWords, c("minnesota", "mn", "the", "and"))

wordcloud(mn_clean)
wordcloud(mn_clean, random.order = F, max.words = 50, scale = c(3, 0.5))