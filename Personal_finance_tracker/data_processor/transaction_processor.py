import pandas as pd
import sys

if len(sys.argv) != 3:
    print("Usage: python transaction_processor.py input.csv output.csv")
    sys.exit(1)

input_file = sys.argv[1]
output_file = sys.argv[2]

try:
    df = pd.read_csv(input_file)
except FileNotFoundError:
    print(f"Error: File {input_file} not found.")
    sys.exit(1)

# Check for required columns
required_columns = ['date', 'description', 'amount']
if not all(col in df.columns for col in required_columns):
    print("Error: CSV must contain 'date', 'description', and 'amount' columns.")
    sys.exit(1)

# Clean the data
df = df.drop_duplicates()
df = df.fillna({'category': 'Uncategorized'})

# Simple categorization
def categorize(description):
    desc = description.lower()
    if 'salary' in desc:
        return 'Income'
    elif 'groceries' in desc:
        return 'Food'
    else:
        return 'Other'

df['category'] = df['description'].apply(categorize)

# Save the processed data
df.to_csv(output_file, index=False)
print(f"Processed data saved to {output_file}")