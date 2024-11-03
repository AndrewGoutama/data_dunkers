import streamlit as st
import joblib
import pandas as pd

# Define the run function for Streamlit
def run():
    st.title("Heart Attack Prediction")

    # Load the model
    try:
        with open('heart_attack_model.pkl', 'rb') as f:
            model = joblib.load(f)
        if not hasattr(model, "predict"):
            raise AttributeError("Loaded pipeline does not have a 'predict' method.")
    except Exception as e:
        st.error(f"Error loading model: {e}")
        return

    # Example input form for user data
    st.header("Enter Patient Data")
    alcohol_consumption = st.selectbox("Alcohol Consumption", [0, 1], index=0)
    sex = st.selectbox("Sex", ["F", "M"], index=0)
    age = st.number_input("Age", min_value=0, value=0, step=1)
    cholesterol = st.number_input("Cholesterol", min_value=0, value=0)
    blood_pressure_category = st.selectbox("Blood Pressure Category", ["Normal", "High"], index=0)
    sistolik = st.number_input("Sistolik", min_value=0, value=0)
    diastolik = st.number_input("Diastolik", min_value=0, value=0)
    heart_rate = st.number_input("Heart Rate", min_value=0, value=0)
    diabetes = st.selectbox("Diabetes", [0, 1], index=0)
    smoking = st.selectbox("Smoking", [0, 1], index=0)
    obesity = st.selectbox("Obesity", [0, 1], index=0)
    exercise_hours = st.number_input("Exercise Hours Per Week", min_value=0.0, value=0.0)
    diet = st.selectbox("Diet", ["Moderate_Diet", "Poor_Diet", "Good_Diet"], index=0)
    medication_use = st.selectbox("Medication Use", [0, 1], index=0)
    stress_level = st.number_input("Stress Level", min_value=0, value=0)
    sedentary_hours = st.number_input("Sedentary Hours Per Day", min_value=0.0, value=0.0)
    bmi = st.number_input("BMI", min_value=0.0, value=0.0)
    triglycerides = st.number_input("Triglycerides", min_value=0, value=0)
    physical_activity_days = st.number_input("Physical Activity Days Per Week", min_value=0, value=0, step=1)
    sleep_hours = st.number_input("Sleep Hours Per Day", min_value=0, value=0, step=1)
    hemisphere = st.selectbox("Hemisphere", ["Northern Hemisphere", "Southern Hemisphere"], index=0)

    # Create a dictionary with the input data
    data_inf = {
        'Alcohol Consumption': [alcohol_consumption],
        'Sex': [sex],
        'Age': [age],
        'Cholesterol': [cholesterol],
        'Blood Pressure Category': [blood_pressure_category],
        'Sistolik': [sistolik],
        'Diastolik': [diastolik],
        'Heart Rate': [heart_rate],
        'Diabetes': [diabetes],
        'Smoking': [smoking],
        'Obesity': [obesity],
        'Exercise Hours Per Week': [exercise_hours],
        'Diet': [diet],
        'Medication Use': [medication_use],
        'Stress Level': [stress_level],
        'Sedentary Hours Per Day': [sedentary_hours],
        'BMI': [bmi],
        'Triglycerides': [triglycerides],
        'Physical Activity Days Per Week': [physical_activity_days],
        'Sleep Hours Per Day': [sleep_hours],
        'Hemisphere': [hemisphere]
    }

    # Convert input data to DataFrame
    input_data = pd.DataFrame(data_inf)

    # Display input data
    st.write("Entered Patient Data:", input_data)

    # Predict button
    if st.button("Predict"):
        try:
            # Make predictions using the loaded model
            prediction = model.predict(input_data)
            st.success(f"Prediction: {'Heart Attack' if prediction[0] == 1 else 'No Heart Attack'}")
        except Exception as e:
            st.error(f"Error during prediction: {e}")

# Run the app
if __name__ == "__main__":
    run()
