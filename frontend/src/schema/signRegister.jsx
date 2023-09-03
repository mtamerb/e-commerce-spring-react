import * as yup from "yup";
const passwordRules = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{5,}$/;
export const Schema = yup.object().shape({
  username: yup.string().required("boş bırakılamaz"),
  password: yup
    .string()
    .min(5, "minimum 5 karakter olmalı")
    .matches(passwordRules, {
      message: "lütfen en az 1 büyük bir küçük harf ve sayı giriniz",
    })
    .required("boş bırakılamaz"),
});
