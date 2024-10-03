import json
import os

# Read the JSON file
json_file = os.path.join(os.getcwd(), 'Random_Questions/all_leetcode_submissions.json')
with open(json_file, 'r') as f:
    submissions = json.load(f)

# Filter the required objects
filtered_submissions = [sub for sub in submissions if 'class Solution' in sub['code'] and 'title_slug' in sub]

# Format the data into markdown
markdown_content = ''
for sub in filtered_submissions:
    markdown_content += f"### Problem: [{sub['title_slug'].replace('-', ' ')}]({sub['problem_url']})\n\n"
    markdown_content += '```java\n'
    markdown_content += sub['code']
    markdown_content += '\n```\n\n'

# Write the markdown file
markdown_file = os.path.join(os.getcwd(), 'all_submissions.md')
with open(markdown_file, 'w') as f:
    f.write(markdown_content)

print(f'Markdown file created: {markdown_file}')
