import { createSlice } from "@reduxjs/toolkit";
export const commerceslice = createSlice({
  name: "commerce",
  initialState: {
    products: [],
    baskets: [],
  },
  reducers: {},
});
//export const {} = commerceslice.actions;
export default commerceslice.reducer;
