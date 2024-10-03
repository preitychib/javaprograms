import requests

def fetch_top_articles(limit):
    top_titles = []
    page = 1
    has_more_pages = True
    all_articles = []
    
    while has_more_pages:
        api_url = f"https://jsonmock.hackerrank.com/api/articles?page={page}"
        response = requests.get(api_url).json()
        
        for article in response['data']:
            all_articles.append(article)
        
        total_pages = response['total_pages']
        has_more_pages = page < total_pages
        page += 1

    all_articles.sort(key=lambda article: (
        article.get('num_comments') if article.get('num_comments') is not None else 0,
        (article.get('title') or article.get('story_title') or '').lower()
    ), reverse=True)

    for i in range(min(limit, len(all_articles))):
        article = all_articles[i]
        title = article.get('title') or article.get('story_title')
        if title:
            top_titles.append(title)

    return top_titles

if __name__ == "__main__":
    try:
        limit = 2  # Adjust limit as needed
        articles = fetch_top_articles(limit)
        print("Top Articles:", articles)
    except Exception as error:
        print(f"An error occurred: {error}")
