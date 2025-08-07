import streamlit as st

st.title("Medical Chatbot")

user_input = st.text_input("Enter your symptoms or query:")
if user_input:
    st.write(f"You said: {user_input}")
    st.write("This is where the chatbot response will go.")