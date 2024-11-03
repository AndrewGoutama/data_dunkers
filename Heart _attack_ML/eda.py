# Import necessary libraries
import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns
import warnings
from sklearn.preprocessing import LabelEncoder
import math


# Function for the EDA app
def run():
    st.title('Exploration Data Analysis (EDA)')
    st.write('Further data analysis to gain deeper insights into the dataset.')

    # Load CSV data
    data = pd.read_csv("Main - FINAL Dataset Project DWDM GROUP 4.csv", delimiter=';')

    # Display top and bottom 10 rows
    st.header('Displaying Top and Bottom Rows')
    st.write("Top 10 rows:")
    st.table(data.head(10))
    st.write("Bottom 10 rows:")
    st.table(data.tail(10))

    # Display data summary for numerical columns
    st.header('Data Frame Summary')
    st.table(data.select_dtypes(include='number').agg(['count', 'skew', 'kurt', 'std', 'mean', 'median', 'min', 'max']))
    # image = Image.open('Melihat deskripsi Data Frame yang akan digunakan.png')
    # st.image(image, caption='Figure 1: Distribution of numerical data')

    # Outlier inspection
    st.header('Outlier Inspection')
    # image = Image.open('Memeriksa outlier.png')
    # st.image(image, caption='Figure 2: Outlier distribution')
    
    # Display data comparison based on Income
    st.header('Data Comparison Based on Income')
    # image = Image.open('Melihat Perbandingan Data Berdasarkan Nilai Income.png')
    # st.image(image, caption='Figure 3: Income-based comparison')

    # Age Distribution
    st.header('Age Distribution')
    # image = Image.open('Melihat Distribusi Umur.png')
    # st.image(image, caption='Figure 4: Age distribution')

    # Age Group and Income Comparison
    st.header('Age Group and Income Comparison')
    # image = Image.open('Melihat Banyak Data Grup Umur dengan Income.png')
    # st.image(image, caption='Figure 5: Age group comparison with Income')

    # Education Type Data Count
    st.header('Education Type Data Count')
    # image = Image.open('Melihat Banyak Data Setiap Jenis Education.png')
    # st.image(image, caption='Figure 6: Education type distribution')

    # Income and Workclass Comparison
    st.header('Income Based on Workclass')
    # image = Image.open('Melihat Perbandingan Income Berdasarkan Workclass.png')
    # st.image(image, caption='Figure 7: Workclass and Income comparison')

    # Income Based on Occupation
    st.header('Income Based on Occupation')
    # image = Image.open('Melihat Perbandingan Income Berdasarkan Occupation.png')
    # st.image(image, caption='Figure 8: Occupation and Income comparison')

    # Income Based on Gender
    st.header('Income Based on Gender')
    # image = Image.open('Melihat Perbandingan Income Berdasarkan Gender.png')
    # st.image(image, caption='Figure 9: Gender and Income comparison')

    # Income Based on Hours-Per-Week
    st.header('Income Based on Hours-Per-Week')
    # image = Image.open('Melihat Perbandingan Income Berdasarkan Hours-Per-Week.png')
    # st.image(image, caption='Figure 10: Hours-Per-Week and Income comparison')

    # Correlation Analysis
    st.header('Categorical Data Correlation with Income')
    # image = Image.open('KORELASI P1M2.png')
    # st.image(image, caption='Figure 11: Categorical data correlation with Income')
