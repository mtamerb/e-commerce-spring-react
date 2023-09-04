import * as yup from "yup";
const passwordRules = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{5,}$/;
const emailRules =
  /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|.(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
export const registerSchema = yup.object().shape({
  email: yup.string().required().matches(emailRules),
  username: yup.string().min(4, "en az 4 karakter olmalı").required(),
  password: yup
    .string()
    .min(4, "minimum 4 karakter olmalı")
    .matches(passwordRules, {
      message: "lütfen en az 1 büyük bir küçük harf ve sayı giriniz",
    })
    .required(),
});
export const signSchema = yup.object().shape({
  username: yup.string().min(4, "en az 4 karakter olmalı").required(),
  password: yup
    .string()
    .min(4, "minimum 4 karakter olmalı")
    .matches(passwordRules, {
      message: "lütfen en az 1 büyük bir küçük harf ve sayı giriniz",
    })
    .required(),
});
export const typChange = () => {
  if (document.getElementById("password").type === "password") {
    document.getElementById("password").type = "text";
  } else {
    document.getElementById("password").type = "password";
  }
};
