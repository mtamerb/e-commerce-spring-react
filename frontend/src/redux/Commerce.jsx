import { createSlice } from "@reduxjs/toolkit";
export const commerceslice = createSlice({
  name: "commerce",
  initialState: {
    products: [],
  },
  reducers: {},
});
//export const {} = commerceslice.actions;
export default commerceslice.reducer;
