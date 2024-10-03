import json
import os

# Read the JSON file
json_file = os.path.join(os.getcwd(), 'Random_Questions/leetcode_submissions_remaining.json')
with open(json_file, 'r') as f:
    submissions = json.load(f)


# Format the data into markdown
markdown_content = ''
for sub in submissions:
    markdown_content += f"### Problem: [{sub['title_slug'].replace('-', ' ')}]({sub['problem_url']})\n\n"
    markdown_content += '```java\n'
    markdown_content += sub['code']
    markdown_content += '\n```\n\n'

# Write the markdown file
markdown_file = os.path.join(os.getcwd(), 'all_remaining_submissions_including_sql_python_js.md')
with open(markdown_file, 'w') as f:
    f.write(markdown_content)

print(f'Markdown file created: {markdown_file}')
