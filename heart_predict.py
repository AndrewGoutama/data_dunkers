import streamlit as st
import pickle
import pandas as pd

# Load your trained model
model = pickle.load(open('heart_attack_model.pkl', 'rb'))  # Assumes model is saved as heart_attack_model.pkl

def run():
    st.title('Heart Attack Prediction')
    st.write("Enter patient data to predict heart attack risk.")

    # Input fields for user to enter relevant data
    age = st.number_input('Age', min_value=18, max_value=100)
    cholesterol = st.number_input('Cholesterol Level', min_value=100, max_value=400)
    blood_pressure = st.number_input('Blood Pressure', min_value=80, max_value=200)
    diabetes = st.selectbox('Diabetes', ['Yes', 'No'])
    smoking = st.selectbox('Smoking Habit', ['Yes', 'No'])
    physical_activity_days = st.slider('Physical Activity Days per Week', 0, 7)

    # Predict button
    if st.button("Predict"):
        input_data = pd.DataFrame({
            'Age': [age],
            'Cholesterol': [cholesterol],
            'BloodPressure': [blood_pressure],
            'Diabetes': [1 if diabetes == 'Yes' else 0],
            'Smoking': [1 if smoking == 'Yes' else 0],
            'PhysicalActivityDays': [physical_activity_days]
        })

        # Make prediction
        prediction = model.predict(input_data)
        st.write("Prediction:", "High risk" if prediction == 1 else "Low risk")
