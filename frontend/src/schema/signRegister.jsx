import * as yup from "yup";
const passwordRules = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{5,}$/;
export const Schema = yup.object().shape({
  username: yup.string().min(4, "en az 4 karakter olmalı").required(),
  password: yup
    .string()
    .min(4, "minimum 4 karakter olmalı")
    .matches(passwordRules, {
      message: "lütfen en az 1 büyük bir küçük harf ve sayı giriniz",
    })
    .required(),
});
