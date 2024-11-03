# eda.py

# Import necessary libraries
import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns
import warnings
from sklearn.preprocessing import LabelEncoder
import math

# Suppress warnings for clear output
warnings.filterwarnings('ignore', category=UserWarning, module='seaborn')

# Load datasets
data_root_kaggle = pd.read_csv("heart_attack_prediction_dataset.csv")
data_root_kaggle[['Exercise Hours Per Week', 'Sedentary Hours Per Day', 'BMI']] = \
    data_root_kaggle[['Exercise Hours Per Week', 'Sedentary Hours Per Day', 'BMI']].astype(float)

data_pre_selected = pd.read_csv("Main - FINAL Dataset Project DWDM GROUP 4.csv", delimiter=';')

# Split Blood Pressure into Systolic and Diastolic
data_pre_selected[['Sistolik', 'Diastolik']] = data_pre_selected['Blood Pressure'].str.split('/', expand=True)
data_pre_selected[['Sistolik', 'Diastolik']] = data_pre_selected[['Sistolik', 'Diastolik']].astype(int)

# Assign selected columns to a new DataFrame
data_pre_selected[['Exercise Hours Per Week', 'Sedentary Hours Per Day', 'BMI']] = \
    data_root_kaggle[['Exercise Hours Per Week', 'Sedentary Hours Per Day', 'BMI']]

data_pre_selected = data_pre_selected[['Patient ID', 'Fullname', 'Age', 'Sex', 'Hospital ID', 'Hospital',
       'Cholesterol', 'Blood Pressure', 'Sistolik', 'Diastolik', 'Heart Rate', 'Diabetes',
       'Family History', 'Smoking', 'Obesity', 'Alcohol Consumption',
       'Exercise Hours Per Week', 'Diet', 'Previous Heart Problems',
       'Medication Use', 'Stress Level', 'Sedentary Hours Per Day', 'Income',
       'BMI', 'Triglycerides', 'Physical Activity Days Per Week',
       'Sleep Hours Per Day', 'Country ID', 'Country', 'Continent ID',
       'Continent', 'Hemisphere ID', 'Hemisphere', 'Heart Attack Risk']]

# Data overview
print("First 10 Rows:\n", data_pre_selected.head(10))
print("Last 10 Rows:\n", data_pre_selected.tail(10))

# Separate numerical and categorical data
data = data_pre_selected[['Age', 'Sex', 'Cholesterol', 'Blood Pressure', 'Sistolik', 'Diastolik', 'Heart Rate', 'Diabetes',
                          'Family History', 'Smoking', 'Obesity', 'Alcohol Consumption', 'Exercise Hours Per Week', 
                          'Diet', 'Previous Heart Problems', 'Medication Use', 'Stress Level', 'Sedentary Hours Per Day', 
                          'Income', 'BMI', 'Triglycerides', 'Physical Activity Days Per Week', 'Sleep Hours Per Day', 
                          'Country', 'Continent', 'Hemisphere', 'Heart Attack Risk']]

data_numerical = data.select_dtypes(include=['float64', 'int64'])
data_categorical = data.select_dtypes(include=['object', 'category'])

# Data info
data.info()

# Unique values per column
print("Unique values:\n", data.nunique())

# Descriptive statistics for numerical columns
describe_numeric = data.select_dtypes(include='number').agg(['count', 'skew', 'kurt', 'std', 'mean', 'median', 'min', 'max'])
print(describe_numeric)

# Check for missing values
missing_values = data.isnull().sum()
print("Missing values in each column:\n", missing_values)

# Duplicate row analysis
duplicate_rows = data.duplicated().sum()
duplicate_percentage = (duplicate_rows / len(data)) * 100
print(f"Duplicate Rows: {duplicate_rows}, Percentage: {duplicate_percentage:.2f}%")

# Drop duplicates
data = data.drop_duplicates()

# Outlier detection summary using IQR
Q1 = data_numerical.quantile(0.25)
Q3 = data_numerical.quantile(0.75)
IQR = Q3 - Q1
lower_bound = Q1 - 1.5 * IQR
upper_bound = Q3 + 1.5 * IQR
outliers = ((data_numerical < lower_bound) | (data_numerical > upper_bound)).sum()
outlier_percentage = (outliers / len(data)) * 100
summary = pd.DataFrame({
    'Missing Values': missing_values,
    'Outliers': outliers,
    'Outlier %': outlier_percentage
})
print(summary)

# Visualizations
# Histogram for numerical non-binary columns
data_numerical_nonbinary = data_numerical.loc[:, ~data_numerical.isin([0, 1]).all()]
num_cols = data_numerical_nonbinary.shape[1]
num_rows = math.ceil(num_cols / 3)
plt.figure(figsize=(24, 5 * num_rows))

for i, col in enumerate(data_numerical_nonbinary.columns, 1):
    plt.subplot(num_rows, 3, i)
    sns.histplot(data_numerical_nonbinary[col], kde=True)
    plt.title(f'Histogram of {col}')

plt.tight_layout()
plt.show()

# Boxplot for numerical columns
num_cols = data_numerical.shape[1]
num_rows = math.ceil(num_cols / 3)
plt.figure(figsize=(24, 5 * num_rows))

for i, col in enumerate(data_numerical.columns, 1):
    plt.subplot(num_rows, 3, i)
    sns.boxplot(x=data_numerical[col])
    plt.title(f'Boxplot of {col}')

plt.tight_layout()
plt.show()

# Barplot for Heart Attack Risk category distribution
plt.figure(figsize=(8, 6))
sns.countplot(x='Heart Attack Risk', data=data)
plt.xlabel('Heart Attack Risk')
plt.ylabel('Count')
plt.title('Heart Attack Risk Distribution')

for i, value in enumerate(data['Heart Attack Risk'].value_counts()):
    plt.text(i, value + 100, f'{value}', ha='center', va='bottom')

plt.tight_layout()
plt.show()

# Heatmap for Spearman correlation of numerical features
plt.figure(figsize=(20, 20))
sns.heatmap(data_numerical.corr(method='spearman'), annot=True)
plt.title('Spearman Correlation (Heatmap)')
plt.show()

# Label encode categorical data for PhiK correlation
label_encoder = LabelEncoder()
data_categorical['Heart Attack Risk'] = label_encoder.fit_transform(data_categorical['Heart Attack Risk'])

# Example of categorical correlation using phik (if available)
try:
    interval_cols = ['Heart Attack Risk']
    phik_overview = data_categorical.phik_matrix(interval_cols=interval_cols)
    plt.figure(figsize=(10, 10))
    sns.heatmap(phik_overview, annot=True, cmap='coolwarm', cbar=True)
    plt.title('PhiK Matrix for Categorical Variables')
    plt.show()
except Exception as e:
    print("PhiK matrix calculation failed:", e)
