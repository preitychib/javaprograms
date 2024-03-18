import pandas as pd
import numpy as np
path="apple_quality.csv"
df=pd.read_csv(path)

#! Dataframe characters
# print("head")
# print(df.head())
# print("info")
# print(df.info())
# print("shape")
# print(df.shape)
# print("Describe")
# print(df.describe(include="all"))

#! view vs copies 
# print(df[df['Sweetness']>6])
#?  this works on copy so changes will not be reflected
# df[df["Sweetness"]>6]["Sweetness"]=5
# see it will be the same
# print(df[df['Sweetness']>6])

# print("after changes by loc")
#! fix
# df.loc[df['Sweetness']>6,'Sweetness']=5 
#! copies value
# df2=df[df['Sweetness']>6].copy()
# print(df2) 

#! rename columns
#  will not work
df.rename(columns={'Weight':'W'}) 
# returns a copy that is saved in df hence changes reflected
df=df.rename(columns={'Weight':'W8'}) 
df.rename(columns={'Size':'Sz'},inplace=True) 
# print(df.columns)

#! changing index
df.set_index("A_id",inplace=True) 
df.index.name="new_index"
# print(df.head())

#! reset index
df.reset_index(inplace=True) 
df.index.name="A_id"
# print(df.head())

#! Adding columns
df['Color']='Red'
# print(df.columns) 

#! delete column
df.drop(['Color'],inplace=True,axis=1)
# print(df.columns) 

# row_1= pd.DataFrame([['4002','34','2','Sweet','crunchy','juicy','ripe','good','Blue']],columns=df.columns,index=[4002])
# df=df.append(row_1)

pd.DataFrame()
df1=pd.DataFrame({'A':[1,2,3],'B':[2,3,4]})
df2=pd.DataFrame({'A':[7,8,9],'B':[4,5,3]})
df3=pd.concat([df1,df2],ignore_index=True)
print(df3)