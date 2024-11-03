import streamlit as st
import pandas as pd
from PIL import Image

def run():
    st.title('Exploratory Data Analysis')
    st.write("This section provides an overview and analysis of the dataset.")

    # Load data
    data = pd.read_csv('heart_attack_data.csv')  # Make sure your dataset is saved as heart_attack_data.csv in the root directory

    # Display dataset sample
    st.header('Sample Data')
    st.table(data.head(10))

    # Descriptive statistics
    st.header('Dataset Statistics')
    st.table(data.describe())

    # Visualizations (Add your own images and explanations here if available)
    st.header('Visual Data Insights')
    st.image('distribution.png', caption="Age and BMI Distribution")  # Example image placeholder
    st.image('correlation_matrix.png', caption="Correlation Matrix Heatmap")

    # Insightful observations
    with st.expander("**Observations**"):
        st.write("""
        - Younger individuals show lower risk factors for heart attacks compared to older individuals.
        - Higher cholesterol and blood pressure levels show strong correlations with heart attack occurrence.
        - Age, blood pressure, cholesterol, and diabetes are significant features influencing heart attack risk.
        """)

    st.write("Explore further with more visualizations.")
