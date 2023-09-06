import commerceReducer from "./Commerce";
import { configureStore } from "@reduxjs/toolkit";
export const store = configureStore({
  reducer: {
    counter: commerceReducer,
  },
});
