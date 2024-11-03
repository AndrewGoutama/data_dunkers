import streamlit as st
import eda
import prediction

# Sidebar menu for navigation
page = st.sidebar.selectbox(label='Menu:', options=['Home', 'Exploratory Data Analysis', 'Model Inference'])

# Home page with project overview
if page == 'Home':
    st.title('Heart Attack Prediction App')
    st.write('This app uses a predictive model to estimate the risk of heart attack based on various health metrics.')

    col1, col2 = st.columns(2)

    # Left column with project details
    col1.write('**Project Name:**')
    col1.write('**Developer:**')
    col1.write('**Objective:**')

    # Right column with specifics
    col2.write('Heart Attack Prediction')
    col2.write('Your Name')
    col2.write("Predict heart attack risk based on health metrics and provide insights into risk factors.")

    st.write("Use the sidebar to navigate between data exploration and prediction.")
    st.markdown("---")

# Exploratory Data Analysis (EDA) Page
elif page == 'Exploratory Data Analysis':
    eda.run()

# Model Inference Page for predictions
else:
    prediction.run()
