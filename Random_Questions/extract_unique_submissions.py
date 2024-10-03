import json
import os

# Read the JSON file
json_file = os.path.join(os.getcwd(), 'Random_Questions/leetcode_submissions_remaining.json')
with open(json_file, 'r') as f:
    submissions = json.load(f)

# Set to track unique question IDs
unique_question_ids = set()

# List to store filtered submissions
filtered_submissions = []

# Filter the required objects with unique question_id
for sub in submissions:
    if sub['question_id'] not in unique_question_ids:
        filtered_submissions.append(sub)
        unique_question_ids.add(sub['question_id'])  # Add question_id to the set to avoid duplicates

# Format the data into markdown
markdown_content = ''
for sub in filtered_submissions:
    markdown_content += f"### Problem: [{sub['title_slug'].replace('-', ' ')}]({sub['problem_url']})\n\n"
    markdown_content += '```java\n'
    markdown_content += sub['code']
    markdown_content += '\n```\n\n'

# Write the markdown file
markdown_file = os.path.join(os.getcwd(), 'all_unique_remaining_submissions.md')
with open(markdown_file, 'w') as f:
    f.write(markdown_content)

print(f'Markdown file created: {markdown_file}')
