object frmAlgoritmoCalidad: TfrmAlgoritmoCalidad
  Left = 0
  Top = 0
  Caption = 'Algoritmo de la calidad - Grupo 4 - 2C2017'
  ClientHeight = 678
  ClientWidth = 1108
  Color = clBtnFace
  Font.Charset = DEFAULT_CHARSET
  Font.Color = clWindowText
  Font.Height = -11
  Font.Name = 'Tahoma'
  Font.Style = []
  OldCreateOrder = False
  OnCreate = FormCreate
  PixelsPerInch = 96
  TextHeight = 13
  object lblPromedioMinimo: TLabel
    Left = 113
    Top = 583
    Width = 294
    Height = 13
    Caption = 'Promedio m'#237'nimo para que sea considerado satisfactorio:  8.2'
    WordWrap = True
  end
  object lblInfo: TLabel
    Left = 590
    Top = 76
    Width = 490
    Height = 16
    Caption = 'asdasdasdasdasdasdasdasdasdasasdasdasdasdasdasdasdasdasdasasdasd'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'Tahoma'
    Font.Style = [fsBold]
    ParentFont = False
    WordWrap = True
  end
  object gbFuncionabilidad: TGroupBox
    Left = 24
    Top = 9
    Width = 489
    Height = 83
    Caption = 'Funcionabilidad'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -11
    Font.Name = 'Tahoma'
    Font.Style = []
    ParentFont = False
    TabOrder = 0
    object lblSeguridadAcceso: TLabel
      Left = 18
      Top = 26
      Width = 99
      Height = 13
      Caption = 'Seguridad de acceso'
    end
    object lblExactitudResultados: TLabel
      Left = 18
      Top = 51
      Width = 113
      Height = 13
      Caption = 'Exactitud de resultados'
    end
    object Panel2: TPanel
      Left = 213
      Top = 45
      Width = 265
      Height = 26
      BevelOuter = bvNone
      TabOrder = 1
      object rbBuena2: TRadioButton
        Left = 18
        Top = 4
        Width = 65
        Height = 17
        Caption = 'Buena'
        TabOrder = 0
        OnClick = rbBuena2Click
      end
      object rbMala2: TRadioButton
        Left = 179
        Top = 4
        Width = 65
        Height = 17
        Caption = 'Mala'
        TabOrder = 1
        OnClick = rbMala2Click
      end
      object rbRegular2: TRadioButton
        Left = 96
        Top = 4
        Width = 65
        Height = 17
        Caption = 'Regular'
        TabOrder = 2
        OnClick = rbRegular2Click
      end
    end
    object Panel1: TPanel
      Left = 213
      Top = 20
      Width = 265
      Height = 26
      BevelOuter = bvNone
      TabOrder = 0
      object rbBuena1: TRadioButton
        Left = 18
        Top = 4
        Width = 65
        Height = 17
        Caption = 'Buena'
        TabOrder = 0
        OnClick = rbBuena1Click
      end
      object rbMala1: TRadioButton
        Left = 179
        Top = 4
        Width = 65
        Height = 17
        Caption = 'Mala'
        TabOrder = 1
        OnClick = rbMala1Click
      end
      object rbRegular1: TRadioButton
        Left = 96
        Top = 4
        Width = 65
        Height = 17
        Caption = 'Regular'
        TabOrder = 2
        OnClick = rbRegular1Click
      end
    end
  end
  object gbEficiencia: TGroupBox
    Left = 24
    Top = 94
    Width = 489
    Height = 83
    Caption = 'Eficiencia'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -11
    Font.Name = 'Tahoma'
    Font.Style = []
    ParentFont = False
    TabOrder = 1
    object lblUtilizacionRecursos: TLabel
      Left = 18
      Top = 25
      Width = 106
      Height = 13
      Caption = 'Utilizaci'#243'n de recursos'
    end
    object lblComportamientoTiempo: TLabel
      Left = 18
      Top = 51
      Width = 140
      Height = 13
      Caption = 'Comportamiento en el tiempo'
    end
    object Panel4: TPanel
      Left = 213
      Top = 45
      Width = 265
      Height = 26
      BevelOuter = bvNone
      TabOrder = 0
      object rbBuena4: TRadioButton
        Left = 18
        Top = 4
        Width = 65
        Height = 17
        Caption = 'Buena'
        TabOrder = 0
        OnClick = rbBuena4Click
      end
      object rbMala4: TRadioButton
        Left = 179
        Top = 4
        Width = 65
        Height = 17
        Caption = 'Mala'
        TabOrder = 1
        OnClick = rbMala4Click
      end
      object rbRegular4: TRadioButton
        Left = 96
        Top = 4
        Width = 65
        Height = 17
        Caption = 'Regular'
        TabOrder = 2
        OnClick = rbRegular4Click
      end
    end
    object Panel3: TPanel
      Left = 213
      Top = 19
      Width = 265
      Height = 26
      BevelOuter = bvNone
      TabOrder = 1
      object rbBuena3: TRadioButton
        Left = 18
        Top = 4
        Width = 65
        Height = 17
        Caption = 'Buena'
        TabOrder = 0
        OnClick = rbBuena3Click
      end
      object rbMala3: TRadioButton
        Left = 179
        Top = 4
        Width = 65
        Height = 17
        Caption = 'Mala'
        TabOrder = 1
        OnClick = rbMala3Click
      end
      object rbRegular3: TRadioButton
        Left = 96
        Top = 4
        Width = 65
        Height = 17
        Caption = 'Regular'
        TabOrder = 2
        OnClick = rbRegular3Click
      end
    end
  end
  object gbFiabilidad: TGroupBox
    Left = 24
    Top = 179
    Width = 489
    Height = 83
    Caption = 'Fiabilidad'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -11
    Font.Name = 'Tahoma'
    Font.Style = []
    ParentFont = False
    TabOrder = 2
    object lblToleranciaFallos: TLabel
      Left = 18
      Top = 23
      Width = 86
      Height = 13
      Caption = 'Tolerancia a fallos'
    end
    object lblRecuperacionErrores: TLabel
      Left = 18
      Top = 49
      Width = 183
      Height = 13
      Caption = 'Capacidad de recuperaci'#243'n de errores'
    end
    object Panel6: TPanel
      Left = 213
      Top = 44
      Width = 678
      Height = 105
      BevelOuter = bvNone
      TabOrder = 0
      object rbBuena6: TRadioButton
        Left = 18
        Top = 4
        Width = 65
        Height = 17
        Caption = 'Buena'
        TabOrder = 0
        OnClick = rbBuena6Click
      end
      object rbMala6: TRadioButton
        Left = 179
        Top = 4
        Width = 65
        Height = 17
        Caption = 'Mala'
        TabOrder = 1
        OnClick = rbMala6Click
      end
      object rbRegular6: TRadioButton
        Left = 96
        Top = 4
        Width = 65
        Height = 17
        Caption = 'Regular'
        TabOrder = 2
        OnClick = rbRegular6Click
      end
    end
    object Panel5: TPanel
      Left = 213
      Top = 17
      Width = 265
      Height = 26
      BevelOuter = bvNone
      TabOrder = 1
      object rbBuena5: TRadioButton
        Left = 18
        Top = 4
        Width = 65
        Height = 17
        Caption = 'Buena'
        TabOrder = 0
        OnClick = rbBuena5Click
      end
      object rbMala5: TRadioButton
        Left = 179
        Top = 4
        Width = 65
        Height = 17
        Caption = 'Mala'
        TabOrder = 1
        OnClick = rbMala5Click
      end
      object rbRegular5: TRadioButton
        Left = 96
        Top = 4
        Width = 65
        Height = 17
        Caption = 'Regular'
        TabOrder = 2
        OnClick = rbRegular5Click
      end
    end
  end
  object gbMantenibilidad: TGroupBox
    Left = 24
    Top = 264
    Width = 489
    Height = 105
    Caption = 'Mantenibilidad'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -11
    Font.Name = 'Tahoma'
    Font.Style = []
    ParentFont = False
    TabOrder = 3
    object lblCapacidadAnalisis: TLabel
      Left = 18
      Top = 23
      Width = 192
      Height = 13
      Caption = 'Capacidad del c'#243'digo para ser analizado'
    end
    object lblCapacidadCambio: TLabel
      Left = 18
      Top = 49
      Width = 192
      Height = 13
      Caption = 'Capacidad del c'#243'digo para ser cambiado'
    end
    object lblEstabilidad: TLabel
      Left = 18
      Top = 76
      Width = 51
      Height = 13
      Caption = 'Estabilidad'
    end
    object Panel8: TPanel
      Left = 213
      Top = 45
      Width = 265
      Height = 26
      BevelOuter = bvNone
      TabOrder = 0
      object rbBuena8: TRadioButton
        Left = 18
        Top = 4
        Width = 65
        Height = 17
        Caption = 'Buena'
        TabOrder = 0
        OnClick = rbBuena8Click
      end
      object rbMala8: TRadioButton
        Left = 179
        Top = 4
        Width = 65
        Height = 17
        Caption = 'Mala'
        TabOrder = 1
        OnClick = rbMala8Click
      end
      object rbRegular8: TRadioButton
        Left = 96
        Top = 4
        Width = 65
        Height = 17
        Caption = 'Regular'
        TabOrder = 2
        OnClick = rbRegular8Click
      end
    end
    object Panel7: TPanel
      Left = 213
      Top = 17
      Width = 265
      Height = 26
      BevelOuter = bvNone
      TabOrder = 1
      object rbBuena7: TRadioButton
        Left = 18
        Top = 4
        Width = 65
        Height = 17
        Caption = 'Buena'
        TabOrder = 0
        OnClick = rbBuena7Click
      end
      object rbMala7: TRadioButton
        Left = 179
        Top = 4
        Width = 65
        Height = 17
        Caption = 'Mala'
        TabOrder = 1
        OnClick = rbMala7Click
      end
      object rbRegular7: TRadioButton
        Left = 96
        Top = 4
        Width = 65
        Height = 17
        Caption = 'Regular'
        TabOrder = 2
        OnClick = rbRegular7Click
      end
    end
    object Panel9: TPanel
      Left = 213
      Top = 71
      Width = 265
      Height = 26
      BevelOuter = bvNone
      TabOrder = 2
      object rbBuena9: TRadioButton
        Left = 18
        Top = 4
        Width = 65
        Height = 17
        Caption = 'Buena'
        TabOrder = 0
        OnClick = rbBuena9Click
      end
      object rbMala9: TRadioButton
        Left = 179
        Top = 4
        Width = 65
        Height = 17
        Caption = 'Mala'
        TabOrder = 1
        OnClick = rbMala9Click
      end
      object rbRegular9: TRadioButton
        Left = 96
        Top = 4
        Width = 65
        Height = 17
        Caption = 'Regular'
        TabOrder = 2
        OnClick = rbRegular9Click
      end
    end
  end
  object gbUsabilidad: TGroupBox
    Left = 24
    Top = 371
    Width = 489
    Height = 105
    Caption = 'Usabilidad'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -11
    Font.Name = 'Tahoma'
    Font.Style = []
    ParentFont = False
    TabOrder = 4
    object lblCapacidadSerEntendido: TLabel
      Left = 18
      Top = 23
      Width = 134
      Height = 13
      Caption = 'Capacidad de ser entendido'
    end
    object lblCapacidadSerOperado: TLabel
      Left = 18
      Top = 50
      Width = 126
      Height = 13
      Caption = 'Capacidad de ser operado'
    end
    object lblCapacidadSerAtractivo: TLabel
      Left = 18
      Top = 76
      Width = 203
      Height = 13
      Caption = 'Capacidad de ser atractivo para el usuario'
    end
    object Panel11: TPanel
      Left = 213
      Top = 44
      Width = 265
      Height = 26
      BevelOuter = bvNone
      TabOrder = 0
      object rbBuena11: TRadioButton
        Left = 18
        Top = 4
        Width = 65
        Height = 17
        Caption = 'Buena'
        TabOrder = 0
        OnClick = rbBuena11Click
      end
      object rbMala11: TRadioButton
        Left = 179
        Top = 4
        Width = 65
        Height = 17
        Caption = 'Mala'
        TabOrder = 1
        OnClick = rbMala11Click
      end
      object rbRegular11: TRadioButton
        Left = 96
        Top = 4
        Width = 65
        Height = 17
        Caption = 'Regular'
        TabOrder = 2
        OnClick = rbRegular11Click
      end
    end
    object Panel10: TPanel
      Left = 213
      Top = 17
      Width = 265
      Height = 26
      BevelOuter = bvNone
      TabOrder = 1
      object rbBuena10: TRadioButton
        Left = 18
        Top = 4
        Width = 65
        Height = 17
        Caption = 'Buena'
        TabOrder = 0
        OnClick = rbBuena10Click
      end
      object rbMala10: TRadioButton
        Left = 179
        Top = 4
        Width = 65
        Height = 17
        Caption = 'Mala'
        TabOrder = 1
        OnClick = rbMala10Click
      end
      object rbRegular10: TRadioButton
        Left = 96
        Top = 4
        Width = 65
        Height = 17
        Caption = 'Regular'
        TabOrder = 2
        OnClick = rbRegular10Click
      end
    end
    object Panel12: TPanel
      Left = 213
      Top = 71
      Width = 265
      Height = 26
      BevelOuter = bvNone
      TabOrder = 2
      object rbBuena12: TRadioButton
        Left = 18
        Top = 4
        Width = 65
        Height = 17
        Caption = 'Buena'
        TabOrder = 0
        OnClick = rbBuena12Click
      end
      object rbMala12: TRadioButton
        Left = 179
        Top = 4
        Width = 65
        Height = 17
        Caption = 'Mala'
        TabOrder = 1
        OnClick = rbMala12Click
      end
      object rbRegular12: TRadioButton
        Left = 96
        Top = 4
        Width = 65
        Height = 17
        Caption = 'Regular'
        TabOrder = 2
        OnClick = rbRegular12Click
      end
    end
  end
  object gbPortabilidad: TGroupBox
    Left = 24
    Top = 480
    Width = 489
    Height = 83
    Caption = 'Portabilidad'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -11
    Font.Name = 'Tahoma'
    Font.Style = []
    ParentFont = False
    TabOrder = 5
    object lblAdaptabilidad: TLabel
      Left = 18
      Top = 27
      Width = 65
      Height = 13
      Caption = 'Adaptabilidad'
    end
    object lblInstalabilidad: TLabel
      Left = 17
      Top = 51
      Width = 63
      Height = 13
      Caption = 'Instalabilidad'
    end
    object Panel14: TPanel
      Left = 213
      Top = 45
      Width = 265
      Height = 26
      BevelOuter = bvNone
      TabOrder = 0
      object rbBuena14: TRadioButton
        Left = 18
        Top = 4
        Width = 65
        Height = 17
        Caption = 'Buena'
        TabOrder = 0
        OnClick = rbBuena14Click
      end
      object rbMala14: TRadioButton
        Left = 179
        Top = 4
        Width = 65
        Height = 17
        Caption = 'Mala'
        TabOrder = 1
        OnClick = rbMala14Click
      end
      object rbRegular14: TRadioButton
        Left = 96
        Top = 4
        Width = 65
        Height = 17
        Caption = 'Regular'
        TabOrder = 2
        OnClick = rbRegular14Click
      end
    end
    object Panel13: TPanel
      Left = 213
      Top = 21
      Width = 265
      Height = 26
      BevelOuter = bvNone
      TabOrder = 1
      object rbBuena13: TRadioButton
        Left = 18
        Top = 4
        Width = 65
        Height = 17
        Caption = 'Buena'
        TabOrder = 0
        OnClick = rbBuena13Click
      end
      object rbMala13: TRadioButton
        Left = 179
        Top = 4
        Width = 66
        Height = 17
        Caption = 'Mala'
        TabOrder = 1
        OnClick = rbMala13Click
      end
      object rbRegular13: TRadioButton
        Left = 96
        Top = 4
        Width = 65
        Height = 17
        Caption = 'Regular'
        TabOrder = 2
        OnClick = rbRegular13Click
      end
    end
  end
  object GroupBox1: TGroupBox
    Left = 152
    Top = 612
    Width = 185
    Height = 45
    Caption = 'Promedio y resultado final'
    TabOrder = 6
    object Label1: TLabel
      Left = 20
      Top = 19
      Width = 37
      Height = 13
      Caption = 'Label1'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -11
      Font.Name = 'Tahoma'
      Font.Style = [fsBold]
      ParentFont = False
    end
  end
  object btnInfoFuncionabilidad: TButton
    Left = 519
    Top = 16
    Width = 26
    Height = 72
    Caption = '(?)'
    TabOrder = 7
    OnClick = btnInfoFuncionabilidadClick
  end
  object btnInfoEficiencia: TButton
    Left = 519
    Top = 101
    Width = 26
    Height = 72
    Caption = '(?)'
    TabOrder = 8
    OnClick = btnInfoEficienciaClick
  end
  object btnInfoFiabilidad: TButton
    Left = 519
    Top = 186
    Width = 26
    Height = 72
    Caption = '(?)'
    TabOrder = 9
    OnClick = btnInfoFiabilidadClick
  end
  object btnInfoMantenibilidad: TButton
    Left = 519
    Top = 281
    Width = 26
    Height = 72
    Caption = '(?)'
    TabOrder = 10
    OnClick = btnInfoMantenibilidadClick
  end
  object btnInfoUsabilidad: TButton
    Left = 519
    Top = 392
    Width = 26
    Height = 72
    Caption = '(?)'
    TabOrder = 11
    OnClick = btnInfoUsabilidadClick
  end
  object btnInfoPortabilidad: TButton
    Left = 519
    Top = 489
    Width = 26
    Height = 72
    Caption = '(?)'
    TabOrder = 12
    OnClick = btnInfoPortabilidadClick
  end
end
