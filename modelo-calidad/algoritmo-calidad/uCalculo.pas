unit uCalculo;

interface

uses
  System.Generics.Collections, uSubCaracteristica;

const
  _PROMEDIO_MINIMO = 8.2;

type
  TCalculo = class
  public
    function PromedioObtenido(ALista: TList<TSubCaracteristica>): Double;
  end;

implementation

uses
  System.Classes, SysUtils;

{ TCalculo }

function TCalculo.PromedioObtenido(
  ALista: TList<TSubCaracteristica>): Double;
var
  LItem: TSubCaracteristica;
  LAcumulador: Double;
begin
  LAcumulador := 0;
  for LItem in ALista do
    LAcumulador := LAcumulador + LItem.GetPonderacion;

  Result := LAcumulador / ALista.Count;
end;

end.
